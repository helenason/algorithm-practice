package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class B1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Integer[] arr = new Integer[input.length()];
        for (int i = 0; i < input.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }

        Arrays.sort(arr, Comparator.reverseOrder());

        for (int a : arr) {
            System.out.print(a);
        }
    }
}
