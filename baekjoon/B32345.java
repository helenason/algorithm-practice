package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B32345 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            long result = -1;
            String s = br.readLine();
            int beforeIndex = -1;
            for (int i = 0; i < s.length(); i++) {
                char token = s.charAt(i);
                if (token == 'a' || token == 'e' || token == 'i' || token == 'o' || token == 'u') {
                    if (beforeIndex == -1) { // 첫번째 모음
                        result = 1;
                    } else {
                        result = (result * (i - beforeIndex)) % (long) (Math.pow(10, 9) + 7);
                    }
                    beforeIndex = i;
                }
            }
            sb.append(result);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
