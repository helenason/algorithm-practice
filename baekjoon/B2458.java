package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2458 {

    static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        arr = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    arr[i][j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            String[] input2 = br.readLine().split(" ");
            int from = Integer.parseInt(input2[0]);
            int to = Integer.parseInt(input2[1]);
            arr[from][to] = true;
        }

        // Floyd Warshall -> 굳이 거리를 계산하지 않아도 되도록 수정
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (!arr[i][j] && arr[i][k] && arr[k][j]) { // i -> j는 불가능이지만, i -> k -> j는 가능이라면
                        arr[i][j] = true;
                    }
                }
            }
        }

        // result
        int result = 0;
        outer: for (int i = 1; i <= n; i++) {
            inner: for (int j = 1; j <= n; j++) {
                if (arr[i][j] || arr[j][i]) { // i -> j 또는 j -> i가 가능하다면
                    continue inner;
                }
                continue outer; // 하나라도 불가능하면 더 이상 볼 것도 없음
            }
            // 모든 노드를 방문할 수 있다면 == 본인의 키 순서를 안다면
            result++;
        }
        System.out.println(result);
    }
}
