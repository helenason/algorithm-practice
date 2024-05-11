package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class B1920 {

    static List<Integer> numbers = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(st.nextToken(" ")));
        }
        numbers.sort(Comparator.comparing(Integer::intValue));

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st2.nextToken(" "));
            binarySearch(0, numbers.size() - 1, target);
        }
        System.out.println(sb);
    }

    static void binarySearch(int left, int right, int target) {
        int mid = (left + right) / 2;
        int midNum = numbers.get(mid);
        if (left > right) {
            sb.append(0);
            sb.append("\n");
            return;
        }

        if (midNum < target) {
            binarySearch(mid + 1, right, target);
        } else if (target < midNum) {
            binarySearch(left, mid - 1, target);
        } else { // midNum == target
            sb.append(1);
            sb.append("\n");
        }
    }
}
