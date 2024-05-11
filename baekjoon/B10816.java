package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B10816 {

    static int[] cards;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        cards = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken(" "));
        }
        Arrays.sort(cards);
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st2.nextToken(" "));
            int rightTarget = findEndRightIndex(target);
            int leftTarget = findEndLeftIndex(target);
            sb.append(rightTarget - leftTarget);
            sb.append(" ");
        }
        System.out.println(sb);
    }

    static int findEndLeftIndex(int target) {
        int left = 0;
        int right = cards.length;

        while (left < right) {
            int mid = (left + right) / 2;
            int midNum = cards[mid];

            if (target <= midNum) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static int findEndRightIndex(int target) {
        int left = 0;
        int right = cards.length;

        while (left < right) {
            int mid = (left + right) / 2;
            int midNum = cards[mid];

            if (target < midNum) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
