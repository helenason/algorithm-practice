package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B31848 {

    static int[] holes;
    static int[] dotoris;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        holes = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i1 = 0;
        while (st.hasMoreTokens()) {
            holes[i1++] = Integer.parseInt(st.nextToken(" "));
        }
        int q = Integer.parseInt(br.readLine());
        dotoris = new int[q];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int i2 = 0;
        while (st2.hasMoreTokens()) {
            dotoris[i2++] = Integer.parseInt(st2.nextToken(" "));
        }

        // 1. 어차피 앞에서 걸러지기 때문에 결국 오름차순 정렬된 형태의 holes이어야 함
        // 예: 1 3 2 == 1 3 3
        for (int i = 0; i < n; i++) {
            holes[i] += i;
            if (i > 0 && holes[i - 1] >= holes[i]) { // 정렬된 형태가 아니라면
                holes[i] = holes[i - 1];
            }
        }

        // 2. 정렬된 형태가 완성되었으므로 이분 탐색이 가능해짐

        for (int target : dotoris) {
            int left = 0;
            int right = n;
            int result = -1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (holes[mid] >= target) { // 가능
                    result = mid;
                    right = mid - 1;
                } else { // 불가능
                    left = mid + 1;
                }
            }
            sb.append(result + 1);
            sb.append(" ");
        }

        System.out.println(sb);
    }
}
