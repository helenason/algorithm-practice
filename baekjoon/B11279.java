package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B11279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (!input.equals("0")) {
                pq.offer(Integer.parseInt(input));
                continue;
            }
            if (pq.isEmpty()) {
                sb.append("0\n");
                continue;
            }
            sb.append(pq.poll());
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
