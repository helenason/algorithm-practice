package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B24444 {

    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    private static int[] result;
    private static int order = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        result = new int[nodeCount + 1];
        for (int node = 1; node <= nodeCount; node++) {
            graph.put(node, new ArrayList<>());
        }
        for (int i = 0; i < edgeCount; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        for (int i = 1; i <= nodeCount; i++) {
            graph.get(i).sort(Comparator.comparingInt(Integer::intValue));
        }

        bfs(startNode);

        StringBuilder sb = new StringBuilder();
        for (int node = 1; node <= nodeCount; node++) {
            sb.append(result[node]);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int start) {
        List<Integer> queue = new ArrayList<>(List.of(start));
        result[start] = order;
        order++;
        queue.add(start);
        while (!queue.isEmpty()) {
            int now = queue.remove(0);
            List<Integer> nearNodes = graph.get(now);
            for (int nearNode : nearNodes) {
                if (result[nearNode] == 0) {
                    result[nearNode] = order;
                    order++;
                    queue.add(nearNode);
                }
            }
        }
    }
}
