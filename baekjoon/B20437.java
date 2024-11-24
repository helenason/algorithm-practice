package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B20437 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) { // 100
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());
            int min = 10001;
            int max = -1;

            int[] alpha = new int[26]; // 알파벳별 개수
            for (int i = 0; i < w.length(); i++) {
                alpha[w.charAt(i) - 'a']++;
            }

            for (int i = 0; i < w.length(); i++) { // 10000
                if (alpha[w.charAt(i) - 'a'] < k) {
                    continue;
                }
                String start = String.valueOf(w.charAt(i));
                int count = k;
                int j = i;
                while (j < w.length() && count > 0) {
                    String end = String.valueOf(w.charAt(j));
                    if (end.equals(start)) {
                        count--;
                    }
                    j++;
                }
                if (count == 0) {
                    int length = j - i;
                    min = Math.min(min, length);
                    max = Math.max(max, length);
                }
            }
            if (min == 10001 && max == -1) {
                sb.append(-1);
                sb.append("\n");
            } else {
                sb.append(min);
                sb.append(" ");
                sb.append(max);
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
