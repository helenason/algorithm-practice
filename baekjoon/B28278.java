package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B28278 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();

        int a = 0;
        while (a++ < num) {
            String input = br.readLine();
            if (input.startsWith("1")) {
                StringTokenizer st = new StringTokenizer(input);
                st.nextToken();
                stack.addLast(Integer.parseInt(st.nextToken()));
                continue;
            }
            switch (input) {
                case "2":
                    sb.append(stack.isEmpty() ? "-1" : stack.removeLast());
                    sb.append("\n");
                    break;
                case "3":
                    sb.append(stack.size());
                    sb.append("\n");
                    break;
                case "4":
                    sb.append(stack.isEmpty() ? "1" : "0");
                    sb.append("\n");
                    break;
                case "5":
                    sb.append(stack.isEmpty() ? "-1" : stack.getLast());
                    sb.append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
