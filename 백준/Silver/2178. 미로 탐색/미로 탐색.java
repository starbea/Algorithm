import java.io.*;
import java.util.*;

class Main {
    static boolean[][] visited;
    static int[][] graph;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int N, M;
  
    static int bfs(int x, int y) {
        visited[x][y] = true;

        Queue<int[]> queue = new LinkedList<>();
        // 시작점: (1, 1), cnt = 1
        queue.offer(new int[] { x, y, 1 });

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int i = 0; i < 4; i++) {
                int tx = cur[0] + dx[i];
                int ty = cur[1] + dy[i];
                int tCnt = cur[2]; 

                if(tx == N && ty == M) {
                    return tCnt + 1;
                }

                if(tx > 0 && tx <= N && ty > 0 && ty <= M) {
                    if(!visited[tx][ty] && graph[tx][ty] == 1) {
                        visited[tx][ty] = true;
                        queue.offer(new int[] { tx, ty, tCnt + 1 });
                    }
                }
            }
        }

        return 0;
    }

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for(int i = 1; i <= N; i++) {
            String s = br.readLine();
            for(int j = 1; j <= M; j++) {
                graph[i][j] = s.charAt(j - 1) - '0';
            }
        }

        System.out.println(bfs(1, 1));

	}
}
