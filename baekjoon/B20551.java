package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B20551 {

    static int n;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(a);

        for (int i = 0; i < m; i++) {
            int d = Integer.parseInt(br.readLine());
            sb.append(findOrder(d));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int findOrder(int target) {
        int left = 0;
        int right = n - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (a[mid] < target) {
                left = mid + 1;
            } else if (a[mid] > target) {
                right = mid - 1;
            } else { // a[mid] == target
                result = mid;
                right = mid - 1;
            }
        }
        return result;
    }
}
