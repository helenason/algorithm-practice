package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B10159 {

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, List<String>> graph_reversed = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            String from = input[0];
            String to = input[1];
            if (graph.containsKey(from)) {
                graph.get(from).add(to);
            } else {
                graph.put(from, new ArrayList<>(List.of(to)));
            }
            if (graph_reversed.containsKey(to)) {
                graph_reversed.get(to).add(from);
            } else {
                graph_reversed.put(to, new ArrayList<>(List.of(from)));
            }
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            // 1. i -> somewhere
            dfs(graph, String.valueOf(i));
            // 2. somewhere -> i (그래프 간선 방향 뒤집기)
            dfs(graph_reversed, String.valueOf(i));
            // 3. 결과 도출
            int result = 0;
            for (int v = 1; v <= n; v++) {
                if (!visited[v]) result++;
            }
            sb.append(result);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(Map<String, List<String>> g, String now) {
        visited[Integer.parseInt(now)] = true;
        List<String> nears = g.getOrDefault(now, new ArrayList<>());
        for (String near : nears) {
            if (!visited[Integer.parseInt(near)]) {
                dfs(g, near);
            }
        }
    }
}
