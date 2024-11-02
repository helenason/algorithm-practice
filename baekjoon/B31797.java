package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class B31797 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        Hand[] hands = new Hand[m * 2];
        int idx = 0;
        for (int i = 1; i <= m; i++) {
            String[] h1h2 = br.readLine().split(" ");
            int h1 = Integer.parseInt(h1h2[0]);
            int h2 = Integer.parseInt(h1h2[1]);
            hands[idx++] = new Hand(i, h1);
            hands[idx++] = new Hand(i, h2);
        }
        Arrays.sort(hands, Comparator.comparing(hand -> hand.floor));
        if (n % (m * 2) == 0) {
            System.out.println(hands[n % (m * 2)].member);
            return;
        }
        System.out.println(hands[n % (m * 2) - 1].member);
    }

    static void printHands(Hand[] hands) {
        Arrays.stream(hands).forEach(hand -> System.out.println(hand.floor + " " + hand.member));
    }

    static class Hand {

        int member;
        int floor;

        Hand(int member, int floor) {
            this.member = member;
            this.floor = floor;
        }
    }
}
