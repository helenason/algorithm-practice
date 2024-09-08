package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B6236 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] arr = new int[n];
        int arrMax = -1;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            arrMax = Math.max(arr[i], arrMax);
        }

        int result = -1;

        int left = arrMax;
        int right = 1000000000;

        while (left <= right) {
            int k = (left + right) / 2; // 인출 금액

            int count = 0;
            int moneyCanUse = 0;
            for (int a : arr) {
                if (moneyCanUse >= a) {
                    moneyCanUse -= a;
                } else {
                    count++;
                    moneyCanUse = k - a;
                }
            }

            if (count <= m) {
                right = k - 1;
                result = k;
            } else {
                left = k + 1;
            }
        }

        System.out.println(result);
    }
}
