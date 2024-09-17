package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B15655 {

    static int n;
    static int m;
    static int[] nums;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        nums = new int[n];
        result = new int[m];
        String[] rawNums = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(rawNums[i]);
        }
        Arrays.sort(nums);

        func(-1, 0);
        System.out.println(sb);
    }

    static void func(int prevIndex, int depth) {
        if (depth == m) {
            print();
            return;
        }
        for (int i = prevIndex + 1; i < n; i++) {
            result[depth] = nums[i];
            func(i, depth + 1);
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
