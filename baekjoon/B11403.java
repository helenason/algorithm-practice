package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B11403 {

    static int n;
    static boolean[] visited;
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] nums = br.readLine().split(" ");
            graph.put(i, new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (nums[j].equals("1")) {
                    List<Integer> list = graph.get(i);
                    list.add(j);
                }
            }
        }
        visited = new boolean[n];

        // ---

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result = 0;
                dfs(i, j, 0);
                visited = new boolean[n];
                if (result > 0) {
                    sb.append(1 + " ");
                } else {
                    sb.append(0 + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int now, int end, int count) { // 시간초과? 모든 경우 탐색 중
        if (now == end && count != 0) {
            result = count;
        }
        for (int near : graph.get(now)) { // 인접 노드들 하나씩 탐색
            if (!visited[near]) { // 방문 전 노드라면
                visited[near] = true; // 방문 처리
                dfs(near, end, count + 1); // 탐색 & count 증가
            }
        }
    }
}
