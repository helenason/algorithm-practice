package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2606 {

    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static boolean[] visited;
    static int count = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());
        int edgeCount = Integer.parseInt(br.readLine());

        visited = new boolean[nodeCount + 1];
        for (int node = 1; node <= nodeCount; node++) {
            graph.put(node, new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        // DFS
        // dfs(1);

        // BFS
        bfs(1);
        System.out.println(count);
    }

    static void dfs(int now) {
        visited[now] = true;
        count++;
        for (int next : graph.get(now)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        List<Integer> queue = new ArrayList<>();

        int now = start;
        queue.add(now);
        visited[now] = true;
        count++;

        while (!queue.isEmpty()) {
            now = queue.remove(0);
            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    count++;
                }
            }
        }
    }
}
