package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B25194 {

    static int n;
    static int[] as;
    static int[] counts; // 7로 나눈 나머지의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        as = new int[n];
        counts = new int[7];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            as[i] = Integer.parseInt(st.nextToken(" "));
        }

        for (int a : as) {
            counts[a % 7]++;
        }

        if (counts[4] != 0) {
            System.out.println("YES");
            return;
        }

        if (dfs(0, 0)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static boolean dfs(int days, int depth) {
        if (depth > n) {
            return false;
        }
        if (days % 7 == 4) { // 조건 만족
            return true;
        }
        for (int i = 1; i < 7; i++) {
            if (counts[i] == 0) {
                continue;
            }
            counts[i]--;
            if (dfs(days + i, depth + 1)) {
                return true;
            }
            counts[i]++;
        }
        return false;
    }
}
