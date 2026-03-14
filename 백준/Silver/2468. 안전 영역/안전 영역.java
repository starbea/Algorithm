import java.io.*;
import java.util.*;

class Main {
    static boolean[][] visited;
    static int[][] graph;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int N;
  
    static void bfs(int x, int y, int h) {
        visited[x][y] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { x, y });

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int i = 0; i < 4; i++) {
                int tx = cur[0] + dx[i];
                int ty = cur[1] + dy[i];

                if(tx >= 0 && tx < N && ty >= 0 && ty < N) {
                    if(!visited[tx][ty] && graph[tx][ty] > h) {
                        visited[tx][ty] = true;
                        queue.offer(new int[] { tx, ty });
                    }
                }
            }
        }
    }

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        visited = new boolean[N][N];
        int max = 1;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(graph[i][j], max);
            }
        }

        int maxCnt = 1;
        for(int h = 1; h < max; h++) {
            int cnt = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j] && graph[i][j] > h) {
                        bfs(i, j, h);
                        cnt++;
                    } 
                }
            }
            maxCnt = Math.max(maxCnt, cnt);
            visited = new boolean[N][N];
        }

        System.out.println(maxCnt);
	}
}
