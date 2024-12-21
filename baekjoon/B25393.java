package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.TreeSet;

public class B25393 {

    static Map<Integer, TreeSet<Integer>> left = new HashMap<>();
    static Map<Integer, TreeSet<Integer>> right = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner sj = new StringJoiner("\n");
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int l = Integer.parseInt(input[0]);
            int r = Integer.parseInt(input[1]);
            left.computeIfAbsent(l, z -> new TreeSet<>()).add(r);
            right.computeIfAbsent(r, z -> new TreeSet<>()).add(l);
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            String[] input = br.readLine().split(" ");
            int q1 = Integer.parseInt(input[0]);
            int q2 = Integer.parseInt(input[1]);
            sj.add(answer(q1, q2));
        }
        System.out.println(sj);
    }

    static public String answer(int q1, int q2) {
        if (!left.containsKey(q1) || !right.containsKey(q2)) {
            return "-1";
        }
        Integer ceiling = left.get(q1).ceiling(q2); // q2와 같거나, 크면서 최소 수
        if (ceiling == null) {
            return "-1";
        } else if (ceiling == q2) { // l == q1 && r == q2
            return "1";
        }

        Integer floor = right.get(q2).floor(q1); // q1과 같거나, 작으면서 최대 수
        if (floor == null) {
            return "-1";
        }
        return "2";
    }
}
