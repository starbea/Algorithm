import java.io.*;
import java.util.*;

// 정렬 기준: 같으면 작은 걸 뒤로
class Main {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static int N;
    static StringBuilder sb;

    static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(' ');

        for(int n : graph.get(start)) {
            if(!visited[n]) {
                visited[n] = true;
                dfs(n);
            }
        }
    }
    
    static void bfs(int start) {
        visited = new boolean[N + 1];
        visited[start] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        sb = new StringBuilder();
        sb.append(start).append(' ');

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int n : graph.get(cur)) {
                if(!visited[n]) {
                    queue.offer(n);
                    visited[n] = true;
                    sb.append(n).append(' ');
                }
            }
        }

        System.out.println(sb);
    }

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visited = new boolean[N + 1];
        sb = new StringBuilder();

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

        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        dfs(V);
        System.out.println(sb);
        bfs(V);

	}
}
