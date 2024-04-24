package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B24479 { // """방문 순서""" 문제 제대로 읽으렴.

    private static Map<Integer, List<Integer>> graph;
    private static int[] result;
    private static int order = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dotCount = Integer.parseInt(st.nextToken());
        int lineCount = Integer.parseInt(st.nextToken());
        int startDot = Integer.parseInt(st.nextToken());

        graph = new HashMap<>();
        for (int n = 1; n <= dotCount; n++) {
            graph.put(n, new ArrayList<>());
        }
        result = new int[dotCount + 1];

        for (int i = 0; i < lineCount; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int startLine = Integer.parseInt(st2.nextToken());
            int endLine = Integer.parseInt(st2.nextToken());
            graph.get(startLine).add(endLine);
            graph.get(endLine).add(startLine);
        }

        for (List<Integer> dots : graph.values()) {
            dots.sort(Comparator.comparing(Integer::intValue));
        }

        dfs(startDot);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < result.length; i++) {
            sb.append(result[i]);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int now) {
        result[now] = order;
        order++;

        List<Integer> dots = graph.getOrDefault(now, List.of());
        for (int next : dots) {
            if (result[next] == 0) {
                dfs(next);
            }
        }
    }
}
