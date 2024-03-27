package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B2798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        List<Integer> cards = new ArrayList<>();
        int a = 0;
        while (a < num) {
            cards.add(Integer.parseInt(st2.nextToken()));
            a++;
        }

        int result = -1;
        for (int i = 0; i < cards.size() - 2; i++) {
            for (int j = i + 1; j < cards.size() - 1; j++) {
                for (int k = j + 1; k < cards.size(); k++) {
                    int tmp = cards.get(i) + cards.get(j) + cards.get(k);
                    if (result < tmp && tmp <= score) {
                        result = tmp;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
