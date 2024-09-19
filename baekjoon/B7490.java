package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B7490 {

    static int n;
    static int[] nums;
    static String soosic;
    static char[] operatorCandidate = {' ', '+', '-'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = i + 1;
            }
            char[] operators = new char[n - 1];
            choose(0, operators);
            System.out.println();
        }
    }

    static void choose(int depth, char[] operators) {
        if (depth == n - 1) {
            if (calculate(nums, operators) == 0) {
                System.out.println(soosic);
            }
            return;
        }
        for (char operator : operatorCandidate) {
            operators[depth] = operator;
            choose(depth + 1, operators);
        }
    }

    static int calculate(int[] nums, char[] operators) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            sb.append(nums[i]);
            sb.append(operators[i]);
        }
        sb.append(nums[n - 1]);
        String joined = sb.toString();
        soosic = joined;
        joined = joined.replace(" ", ""); // 공백 제거

        // 계산 시작
        int result = 0;

        int i = 0;
        int tmp = 0;
        char op = ' ';
        while (i < joined.length()) {
            if (joined.charAt(i) == '+') {
                op = '+';
            } else if (joined.charAt(i) == '-') {
                op = '-';
            } else { // number
                while (i < joined.length() && !isOperator(joined.charAt(i))) {
                    tmp *= 10;
                    tmp += Integer.parseInt(String.valueOf(joined.charAt(i)));
                    i++;
                }
                if (op == '+') {
                    result += tmp;
                } else if (op == '-') {
                    result -= tmp;
                } else { // op == ' '
                    result += tmp;
                }
                tmp = 0;
                if (i < joined.length() - 1) {
                    i--; // 포인터 돌려놔
                }
            }
            i++;
        }
        return result;
    }

    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == ' ';
    }

    static void printNums(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    static void printOperators(char[] ops) {
        for (char op : ops) {
            System.out.print(op + " ");
        }
        System.out.println();
    }
}
