package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1032 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            names[i] = name;
        }

        StringBuilder result = new StringBuilder();
        int lengthOfName = names[0].length();
        outer: for (int i = 0; i < lengthOfName; i++) {
            char std = names[0].charAt(i);
            for (String name : names) {
                if (std != name.charAt(i)) {
                    result.append("?");
                    continue outer;
                }
            }
            result.append(names[0].charAt(i));
        }

        System.out.println(result);
    }
}
