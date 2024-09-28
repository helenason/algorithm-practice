package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B13023 {

    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            dfs(i, 0);
        }
        System.out.println(0);
    }

    static void dfs(int now, int depth) {
        if (depth == 4) {
            System.out.println(1);
            System.exit(0);
        }
        List<Integer> friends = graph.get(now);
        if (friends.isEmpty()) {
            return;
        }
        for (Integer friend : friends) {
            if (visited[friend]) {
                continue;
            }
            visited[friend] = true;
            dfs(friend, depth + 1);
            visited[friend] = false;
        }
    }
}
