package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S20019 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int count = 0;
        while (count++ < t) {
            String input = br.readLine();
            int n = input.length();
            if (isPalindrome(input) && isPalindrome(input.substring(0, (n - 1) / 2)) && isPalindrome(input.substring((n - 1) / 2 + 1))) {
                sb.append("#");
                sb.append(count);
                sb.append(" YES\n");
            } else {
                sb.append("#");
                sb.append(count);
                sb.append(" NO\n");
            }
        }
        System.out.println(sb);
    }

    static boolean isPalindrome(String input) {
        int n = input.length();
        for (int i = 0; i < n / 2; i++) {
            if (input.charAt(i) != input.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
