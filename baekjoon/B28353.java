package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B28353 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        String[] rawCats = br.readLine().split(" ");
        int[] cats = new int[n];
        for (int i = 0; i < n; i++) {
            cats[i] = Integer.parseInt(rawCats[i]);
        }

        System.out.println(solve(n, k, cats));
    }

    static int solve(int n, int k, int[] cats) {
        boolean[] isVisited = new boolean[n];
        int result = 0;
        Arrays.sort(cats);
        outer: for (int i = n - 1; i >= 1; i--) {
            if (isVisited[i]) {
                continue;
            }
            inner: for (int j = i - 1; j >= 0; j--) {
                if (isVisited[j]) {
                    continue;
                }
                if (cats[i] + cats[j] <= k) {
                    result++;
                    isVisited[i] = true;
                    isVisited[j] = true;
                    continue outer;
                }
            }
        }
        return result;
    }
}
