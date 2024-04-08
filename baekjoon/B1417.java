package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B1417 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> votes = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            votes.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        int ds_index = 0;
        while (true) {
            int max = -1;
            int max_index = -1;
            for (int i = 1; i < votes.size(); i++) {
                if (votes.get(i) > max) {
                    max = votes.get(i);
                    max_index = i;
                }
            }
            if (votes.get(0) > max) {
                System.out.println(result);
                return;
            }
            votes.set(ds_index, votes.get(0) + 1);
            votes.set(max_index, votes.get(max_index) - 1);
            result++;
        }
    }
}
