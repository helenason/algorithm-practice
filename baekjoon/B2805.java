package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[] trees = new int[n];
        int maxTree = -1;
        String[] rawTrees = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int tree = Integer.parseInt(rawTrees[i]);
            maxTree = Math.max(tree, maxTree);
            trees[i] = tree;
        }

        int left = 0;
        int right = maxTree;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += trees[i] > mid ? trees[i] - mid : 0;
            }

            if (sum < m) {
                right = mid - 1;
            } else { // sum >= m
                left = mid + 1;
                result = mid;
            }
        }
        System.out.println(result);
    }
}
