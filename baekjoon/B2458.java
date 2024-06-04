package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B2458 {

    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static Map<Integer, List<Integer>> graph_reversed = new HashMap<>();
    static boolean[] visited; // list doubling

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        for (int i = 0; i < m; i++) {
            String[] input2 = br.readLine().split(" ");
            int from = Integer.parseInt(input2[0]);
            int to = Integer.parseInt(input2[1]);
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

        int result = 0;
        for (int student = 1; student <= n; student++) {
            visited = new boolean[n + 1];
            int count = dfs(student, graph) + dfs(student, graph_reversed) - 1;
            if (count == n) {
                result++;
            }
        }
        System.out.println(result);
    }

    static int dfs(int now, Map<Integer, List<Integer>> graph) {
        int count = 1;
        visited[now] = true;
        for (int near : graph.getOrDefault(now, List.of())) {
            if (!visited[near]) {
                count += dfs(near, graph);
            }
        }
        return count;
    }
}
