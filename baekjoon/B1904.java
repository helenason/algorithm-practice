package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1904 {

    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        numbers = new int[1000001];
        for (int i = 1; i <= n; i++) {
            fillNumber(i);
        }
        System.out.println(numbers[n]);
    }

    private static void fillNumber(int num) {
        if (num == 1 || num == 2) {
            numbers[num] = num;
            return;
        }
        if (numbers[num] != 0) {
            return;
        }
        numbers[num] = (numbers[num - 2] + numbers[num - 1]) % 15746;
    }
}
