package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B1991 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 1 ~ 26
        Map<String, String> left = new HashMap<>();
        Map<String, String> right = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String mid = input[0];
            left.put(mid, input[1]);
            right.put(mid, input[2]);
        }

        // 전위: 루트 -> 왼 -> 오
        String tmp1 = "A";
        List<String> visited = new ArrayList<>();
        while (tmp1.length() < n) {
            for (int i = 0; i < tmp1.length() && tmp1.length() < n; i++) {
                String target = String.valueOf(tmp1.charAt(i));
                if (visited.contains(target)) {
                    continue;
                }
                String l = left.get(target);
                String r = right.get(target);
                visited.add(target);

                tmp1 = tmp1.replace(target, target + l + r)
                        .replace(".", "");
            }
        }
        System.out.println(tmp1);

        // 중위: 왼 -> 루트 -> 오
        String tmp2 = "A";
        visited.clear();
        while (tmp2.length() < n) {
            for (int i = 0; i < tmp2.length() && tmp2.length() < n; i++) {
                String target = String.valueOf(tmp2.charAt(i));
                if (visited.contains(target)) {
                    continue;
                }
                String l = left.get(target);
                String r = right.get(target);
                visited.add(target);

                tmp2 = tmp2.replace(target, l + target + r)
                        .replace(".", "");
            }
        }
        System.out.println(tmp2);

        // 후위: 왼 -> 오 -> 루트
        String tmp3 = "A";
        visited.clear();
        while (tmp3.length() < n) {
            for (int i = 0; i < tmp3.length() && tmp3.length() < n; i++) {
                String target = String.valueOf(tmp3.charAt(i));
                if (visited.contains(target)) {
                    continue;
                }
                String l = left.get(target);
                String r = right.get(target);
                visited.add(target);

                tmp3 = tmp3.replace(target, l + r + target)
                        .replace(".", "");
            }
        }
        System.out.println(tmp3);
    }
}
