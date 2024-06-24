package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B11725 {

    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (graph.containsKey(a)) {
                graph.get(a).add(b);
            } else {
                graph.put(a, new ArrayList<>(List.of(b)));
            }
            if (graph.containsKey(b)) {
                graph.get(b).add(a);
            } else {
                graph.put(b, new ArrayList<>(List.of(a)));
            }
        }

        dfs(1);

        for (int node = 2; node <= n; node++) {
            sb.append(parent[node]);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int now) {
        visited[now] = true;
        List<Integer> nexts = graph.get(now);
        for (Integer next : nexts) {
            if (!visited[next]) {
                parent[next] = now;
                dfs(next);
            }
        }
    }
}
