import java.io.*;
import java.util.*;

// 둘이 똑같음
// 1 -> 2 -> 3 -> 4 -> 1
// 2 -> 3 -> 4 -> 1 -> 2 

class Main {
    static int N;
    static boolean[] visited;
    static int[][] map;
    static int min = Integer.MAX_VALUE;

    static void dfs(int start, int now, int depth, int sum) {
        if (sum >= min) return;

        if(depth == N) {
            if (map[now][start] != 0) {
                min = Math.min(min, sum + map[now][start]);
            }
            return;
        }

        for(int i = 0; i < N; i++) {
            if (!visited[i] && map[now][i] != 0) {
                visited[i] = true;
                dfs(start, i, depth + 1, sum + map[now][i]);
                visited[i] = false;
            }
        }
    }

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0] = true;
        dfs(0, 0, 1, 0);

        System.out.println(min);
   
	}
}