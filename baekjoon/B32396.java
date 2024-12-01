package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B32396 {

    public static void main(String[] args) throws IOException {
        // (간격 조정이 필요한 횟수 + 1) / 2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        long m = Long.parseLong(nm[1]);
        List<Integer> needs = new ArrayList<>();
        long[] as = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            as[i] = Long.parseLong(st.nextToken(" "));
            if (i == 0) {
                continue;
            }
            if (Math.abs(as[i] - as[i - 1]) >= m) { // 조건 만족 (차이가 M 이상)
                needs.add(count);
                count = 0; // init
                continue;
            }
            // 조건 불만족 (차이가 M 미만)
            count++; // 조정이 필요한 연속된 간격의 개수
        }
        if (count != 0) {
            needs.add(count);
        }

        int sum = 0;
        for (int need : needs) {
            sum += (need + 1) / 2;
        }
        System.out.println(sum);
    }
}
