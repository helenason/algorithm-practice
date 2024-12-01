package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class B32359 {

    static long maxNode = (long) Math.pow(2, 60);
    static int result = 0;
    static Set<Long> vs = new HashSet<>();

    static boolean dfs(long now) {
        if (now >= maxNode) {
            return false;
        }
        if (vs.contains(now)) {
            return true;
        }
        result++;

        if (!dfs(now * 2)) {
            return false;
        }
        if (!dfs(now * 2 + 1)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] raw_vs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            vs.add(Long.parseLong(raw_vs[i]));
        }

        if (!dfs(1)) { // 무한집합
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}
