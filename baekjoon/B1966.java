package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class B1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            String[] rawQueue = br.readLine().split(" ");
            List<Integer> queue = new ArrayList<>();
            List<Integer> sortedQueue = new ArrayList<>();
            for (String q : rawQueue) {
                queue.add(Integer.parseInt(q));
                sortedQueue.add(Integer.parseInt(q));
            }
            sortedQueue.sort(Comparator.reverseOrder());

            int count = 0;
            while (true) {
                int target = queue.get(0);
                if (target == sortedQueue.get(0)) { // target == max
                    queue.remove(0);
                    sortedQueue.remove(0);
                    count++;
                    if (m == 0) {
                        break;
                    }
                    m--;
                } else { // target != max
                    queue.add(target);
                    queue.remove(0);
                    if (m == 0) {
                        m = queue.size() - 1;
                    } else {
                        m--;
                    }
                }
            }
            sb.append(count);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
