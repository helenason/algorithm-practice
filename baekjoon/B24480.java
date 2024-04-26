package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B24480 {

    private static final Map<Integer, List<Integer>> graph = new HashMap<>();
    private static int[] result;
    private static int order = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int nodeCount = Integer.parseInt(input[0]);
        int edgeCount = Integer.parseInt(input[1]);
        int startNode = Integer.parseInt(input[2]);

        result = new int[nodeCount + 1];
        for (int node = 1; node <= nodeCount; node++) {
            graph.put(node, new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            String[] edge = br.readLine().split(" ");
            int start = Integer.parseInt(edge[0]);
            int end = Integer.parseInt(edge[1]);
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        for (List<Integer> nodes : graph.values()) {
            nodes.sort(Comparator.reverseOrder());
        }

        dfs(startNode);

        for (int i = 1; i <= nodeCount; i++) {
            System.out.println(result[i]);
        }
    }

    private static void dfs(int now) {
        result[now] = order;
        order++;

        List<Integer> nearNodes = graph.get(now);
        for (Integer next : nearNodes) {
            if (result[next] == 0) {
                dfs(next);
            }
        }
    }
}
