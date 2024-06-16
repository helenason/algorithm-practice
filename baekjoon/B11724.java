package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B11724 {

    static int n;
    static int m;
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            if (graph.containsKey(start)) {
                graph.get(start).add(end);
            } else {
                graph.put(start, new ArrayList<>(List.of(end)));
            }
            if (graph.containsKey(end)) {
                graph.get(end).add(start);
            } else {
                graph.put(end, new ArrayList<>(List.of(start)));
            }
        }

        for (int startNode = 1; startNode <= n; startNode++) {
            if (!visited[startNode]) {
                bfs(startNode);
                result++;
            }
        }
        System.out.println(result);
    }

    static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            List<Integer> nexts = graph.get(now);
            if (nexts == null) {
                continue;
            }
            for (Integer next : nexts) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
