package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B32194 {

    static int[] yesCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        yesCount = new int[n + 2];
        yesCount[1] = 1;
        for (int i = 2; i <= n + 1; i++) {
            String[] input = br.readLine().split(" ");
            String target = input[0];
            if (target.equals("1")) { // Yes 인가
                int x = Integer.parseInt(input[1]);
                int y = Integer.parseInt(input[2]);
                int yeses = yesCount[y] - yesCount[x - 1];
                if (yeses == y - x + 1) {
                    sb.append("Yes\n");
                    yesCount[i] = yesCount[i - 1] + 1;
                    continue;
                }
                sb.append("No\n");
                yesCount[i] = yesCount[i - 1];
            }
            if (target.equals("2")) { // No 인가
                int x = Integer.parseInt(input[1]);
                int y = Integer.parseInt(input[2]);
                int yeses = yesCount[y] - yesCount[x - 1];
                if (yeses == 0) {
                    sb.append("Yes\n");
                    yesCount[i] = yesCount[i - 1] + 1;
                    continue;
                }
                sb.append("No\n");
                yesCount[i] = yesCount[i - 1];
            }
        }
        System.out.println(sb);
    }
}
