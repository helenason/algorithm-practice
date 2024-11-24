package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class B32201 {

    static String[] as;
    static String[] bs;
    static Map<String, Changed> changed = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        as = new String[n];
        bs = new String[n];
        int i = 0;
        while (st1.hasMoreTokens()) {
            as[i] = st1.nextToken();
            bs[i] = st2.nextToken();
            i++;
        }

        for (int before = 0; before < as.length; before++) { // 100,000
            String backNumber_a = as[before];
            changed.put(backNumber_a, new Changed(backNumber_a, -1, before));
        }

        for (int after = 0; after < bs.length; after++) { // 100,000
            String backNumber_b = bs[after];
            Changed a = changed.get(backNumber_b);
            a.finalRank = after;
            a.changed -= after;
        }

        List<Changed> values = new ArrayList<>(changed.values());
        Collections.sort(values);

        int maxChanged = values.get(0).changed;
        for (Changed value : values) {
            if (value.changed == maxChanged) {
                sb.append(value.backNumber);
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }

    static class Changed implements Comparable<Changed> {

        String backNumber;
        int finalRank;
        int changed;

        Changed(String backNumber, int finalRank, int changed) {
            this.backNumber = backNumber;
            this.finalRank = finalRank;
            this.changed = changed;
        }

        @Override
        public int compareTo(Changed object) {
            if (this.changed == object.changed) {
                return this.finalRank - object.finalRank; // 오름차순
            }
            return object.changed - this.changed; // 내림차순
        }
    }
}
