package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        String[] arr = br.readLine().split(" ");
        int[] sumArr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) { // 100,000
            sumArr[i] = sumArr[i - 1] + Integer.parseInt(arr[i - 1]);
        }
        while (m-- > 0) { // 100,000
            String[] rawRange = br.readLine().split(" ");
            int i = Integer.parseInt(rawRange[0]);
            int j = Integer.parseInt(rawRange[1]);

            if (i == 1) {
                sb.append(sumArr[j]);
            } else {
                sb.append(sumArr[j] - sumArr[i - 1]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
