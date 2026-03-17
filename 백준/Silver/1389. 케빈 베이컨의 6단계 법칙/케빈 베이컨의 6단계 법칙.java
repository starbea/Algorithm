import java.io.*;
import java.util.*;

class Main {
    static int N;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;

    static int bfs(int start) {
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(int next : graph.get(now)) {
                if(!visited[next]) {
                    dist[next] = dist[now] + 1;
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }

        int sum = 0;
        for(int i = 1; i <= N; i++) {
            sum += dist[i];
        }

        return sum;
    }

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int result = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++) {
            int sum = bfs(i);

            if(sum < min) {
                min = sum;
                result = i;
            }
        }
     
        System.out.println(result);
	}
}