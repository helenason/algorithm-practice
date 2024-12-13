package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B19637 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Power[] powers = new Power[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer stst = new StringTokenizer(br.readLine());
            powers[i] = new Power(stst.nextToken(), Integer.parseInt(stst.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(br.readLine());

            // 이분탐색
            String result = "dummy";

            int left = 0;
            int right = powers.length;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (target <= powers[mid].num) { // 조건 만족
                    result = powers[mid].name;
                    right = mid - 1;
                } else { // target > num
                    left = mid + 1;
                }
            }
            sb.append(result);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static class Power {

        String name;
        int num;

        Power(String name, int num) {
            this.name = name;
            this.num = num;
        }
    }
}
