package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B10815 {

    static int n;
    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        cards = new int[n];
        String[] raw_cards = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(raw_cards[i]);
        }
        int m = Integer.parseInt(br.readLine());
        int[] cards_check = new int[m];
        String[] raw_cards_check = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            cards_check[i] = Integer.parseInt(raw_cards_check[i]);
        }

        Arrays.sort(cards);

        for (int i = 0; i < m; i++) {
            if (contains(cards_check[i])) {
                sb.append(1);
                sb.append(" ");
            } else {
                sb.append(0);
                sb.append(" ");
            }
        }

        System.out.println(sb);
    }

    static boolean contains(int target) {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < cards[mid]) {
                right = mid - 1;
            } else if (cards[mid] < target) {
                left = mid + 1;
            } else { // cards[mid] == target
                return true;
            }
        }
        return false;
    }
}
