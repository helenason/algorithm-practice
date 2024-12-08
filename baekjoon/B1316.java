package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1316 {

    static boolean[] visited; // a ~ z
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        outer: for (int i = 0; i < n; i++) {
            String input = br.readLine();
            char now = '1'; // 현재 연속으로 측정 중인 문자
            visited = new boolean[26];
            for (int j = 0; j < input.length(); j++) {
                char token = input.charAt(j); // y
                if (token == now) { // 연속된 문자라면
                    continue;
                }
                // 연속된 문자가 아니라면
                now = token; // 측정 중인 문자 갱신
                if (visited[token - 'a']) { // 이미 이전에 나왔던 문자라면 그룹 단어 X
                    continue outer;
                }
                visited[token - 'a'] = true;
            }
            result++;
        }
        System.out.println(result);
    }
}
