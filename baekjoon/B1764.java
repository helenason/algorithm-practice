package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class B1764 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String rawNumbers = br.readLine();
        StringTokenizer st = new StringTokenizer(rawNumbers);
        int n = Integer.parseInt(st.nextToken(" "));
        int m = Integer.parseInt(st.nextToken(" "));

        Set<String> names = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            names.add(name);
        }
        Set<String> result = new HashSet<>();
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (names.contains(name)) {
                result.add(name);
            }
        }
        List<String> resultList = new ArrayList<>(result);
        if (resultList.isEmpty()) {
            System.out.println(0);
            return;
        }
        resultList.sort(String::compareTo);
        StringBuilder sb = new StringBuilder();
        sb.append(result.size());
        sb.append("\n");
        for (String name : resultList) {
            sb.append(name);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
