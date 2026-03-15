import java.io.*;
import java.util.*;

class Main {
    static int M, N;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static ArrayList<Integer> list;
  
    static void bfs(int x, int y) {
        visited[x][y] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { x, y });

        int cnt = 1;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int i = 0; i < 4; i++) {
                int tx = cur[0] + dx[i];
                int ty = cur[1] + dy[i];

                if(tx >= 0 && tx < M && ty >= 0 && ty < N) {
                    if(!visited[tx][ty]) {
                        visited[tx][ty] = true;
                        queue.offer(new int[] { tx, ty });
                        cnt++;
                    }
                }
            }
        }

        list.add(cnt);
    }

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visited = new boolean[M][N];
        
        for(int t = 0; t < K; t++) {
            st = new StringTokenizer(br.readLine());

            int y1 = Integer.parseInt(st.nextToken());
            int x1 = M - Integer.parseInt(st.nextToken()) - 1;

            int y2 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = M - Integer.parseInt(st.nextToken());

            for(int i = x2; i <= x1; i++) {
                for(int j = y1; j <= y2; j++) {
                    visited[i][j] = true;
                }
            }
        }

        list = new ArrayList<>();

        int cnt = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }
  
        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append('\n');
        for(int n : list) {
            sb.append(n).append(' ');
        }

        System.out.println(sb);
	}
}
