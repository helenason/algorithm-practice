package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B32762 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        for (int i = 0; i < n; i++) {
            br.readLine();
        }
        double sum = 0.0000; // 총 가격
        for (int i = 0; i < m; i++) {
            sum += Integer.parseInt(br.readLine().split(" ")[1]);
        }
        System.out.printf("%.5f\n", sum / n);
    }
}
