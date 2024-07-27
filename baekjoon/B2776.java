package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2776 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] answers = new int[n];
            String[] rawAnswers = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                answers[i] = Integer.parseInt(rawAnswers[i]);
            }
            Arrays.sort(answers);

            int m = Integer.parseInt(br.readLine());
            String[] rawNotes = br.readLine().split(" ");

            outer: for (int i = 0; i < m; i++) {
                int target = Integer.parseInt(rawNotes[i]);

                int left = 0;
                int right = n - 1;

                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (answers[mid] < target) {
                        left = mid + 1;
                    } else if (target < answers[mid]) {
                        right = mid - 1;
                    } else {
                        sb.append(1);
                        sb.append("\n");
                        continue outer;
                    }
                }
                sb.append(0);
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
