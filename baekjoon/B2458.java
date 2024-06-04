package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2458 {

    static int[][] arr;
    static int[][] arr_reversed;
    static int max = 999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        arr = new int[n + 1][n + 1];
        arr_reversed = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    arr[i][j] = 0;
                    arr_reversed[i][j] = 0;
                    continue;
                }
                arr[i][j] = max;
                arr_reversed[i][j] = max;
            }
        }
        for (int i = 0; i < m; i++) {
            String[] input2 = br.readLine().split(" ");
            int from = Integer.parseInt(input2[0]);
            int to = Integer.parseInt(input2[1]);
            arr[from][to] = 1;
            arr_reversed[to][from] = 1;
        }

        // Floyd Warshall => 얘를 사용하는 이유가 뭐임? 굳이 최단 거리를 왜 구함?
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) { // 더 짧은 거리가 있다면 갱신
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr_reversed[i][j] > arr_reversed[i][k] + arr_reversed[k][j]) { // 더 짧은 거리가 있다면 갱신
                        arr_reversed[i][j] = arr_reversed[i][k] + arr_reversed[k][j];
                    }
                }
            }
        }

        // result
        int result = 0;
        outer: for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (Math.min(arr[i][j], arr_reversed[i][j]) == max) {
                    continue outer; // 더 이상 볼 것도 없음
                }
            }
            // 모든 노드를 방문할 수 있다면 == 본인의 키 순서를 안다면
            result++;
        }
        System.out.println(result);
    }
}
