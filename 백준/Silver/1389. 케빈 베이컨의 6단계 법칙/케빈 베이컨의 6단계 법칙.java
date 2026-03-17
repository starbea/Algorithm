import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static int min = Integer.MAX_VALUE;
    static int result = 1;

    static void bfs(int start) {
        visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        for(int n : graph.get(start)) {
            queue.offer(n);
            dist[n] = 1;
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int n : graph.get(cur)) {
                if(dist[n] == 0) {
                    dist[n] = dist[cur] + 1;
                    queue.offer(n);
                }
            }
        }
        dist[start] = 0;
        
        int sum = 0;
        for(int i = 1; i <= N; i++) {
            sum += dist[i];
        }
        if(sum < min) {
            min = sum;
            result = start;
        }
    }

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

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

        for(int i = 1; i <= N; i++) {
            bfs(i);
        }
     
        System.out.println(result);
	}
}
