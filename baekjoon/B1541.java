package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1541 {

    private static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] expressions = input.split("-");

        for (int i = 0; i < expressions.length; i++) {
            String[] numbers = expressions[i].split("\\+");
            for (String number : numbers) {
                if (i == 0) {
                    result += Integer.parseInt(number);
                    continue;
                }
                result -= Integer.parseInt(number);
            }
        }
        System.out.println(result);
    }
}
