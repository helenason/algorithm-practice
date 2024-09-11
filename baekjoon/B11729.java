package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11729 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 1 ~ 20

//        int[] count = new int[n + 1];
//        count[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            count[i] = count[i - 1] * 2 + 1;
//        }
        String[] path = new String[n + 1];

        path[1] = "1 3";
        for (int i = 2; i <= n; i++) {
            path[i] = String.join("\n",
                    swap(path[i - 1], '2', '3'),
                    path[1],
                    swap(path[i - 1], '1', '2'));
        }
        System.out.println(path[n].split("\n").length);
        System.out.println(path[n]);
    }

    static String swap(String target, char a, char b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == a) {
                sb.append(b);
            } else if (target.charAt(i) == b) {
                sb.append(a);
            } else {
                sb.append(target.charAt(i));
            }
        }
        return sb.toString();
    }
}
