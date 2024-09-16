package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B15654 {

    static int n;
    static int m;
    static int[] nums;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        nums = new int[n];
        result = new int[m];
        visited = new boolean[n];
        String[] rawNums = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(rawNums[i]);
        }
        Arrays.sort(nums);

        func(0);
        System.out.println(sb);
    }

    static void func(int depth) {
        if (depth == m) {
            print();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            result[depth] = nums[i];
            visited[i] = true;
            func(depth + 1);
            visited[i] = false;
        }
    }

    static void print() {
        for (int r : result) {
            sb.append(r);
            sb.append(" ");
        }
        sb.append("\n");
    }
}
