import java.io.*;
import java.util.*;

class Main {
    static boolean[] visited;
    static int[] dir;
    static int F, G;
  
    static int bfs(int start) {
        visited[start] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { start, 0 });

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            if(cur[0] == G) return cur[1];

            for(int i = 0; i < 2; i++) {
                int tCur = cur[0] + dir[i];

                if(tCur > 0 && tCur <= F) {
                    if(!visited[tCur]) {
                        visited[tCur] = true;
                        queue.offer(new int[] { tCur, cur[1] + 1 });
                    }
                }
            }
        }
        return -1;
    }

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        visited = new boolean[F + 1];
    
        int S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());

        dir = new int[2];
        dir[0] = Integer.parseInt(st.nextToken());
        dir[1] = - Integer.parseInt(st.nextToken());

        int result = bfs(S);

        System.out.println(result == -1 ? "use the stairs" : result);

	}
}
