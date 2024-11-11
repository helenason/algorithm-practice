package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.Arrays;

public class B32530 {

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] times = new String[n];
        for (int i = 0; i < n; i++) {
            times[i] = br.readLine();
        }

        Arrays.sort(times);

        int pnt = 0;
        while (pnt < n) {
            String left = times[pnt]; // 모임 첫 학생
            pnt++;
            int togetherCount = 1;
            while (pnt < n && minuteGap(left, times[pnt]) <= 20 && togetherCount++ < 3) {
                pnt++;
            }
            result++;
        }

        System.out.println(result);
    }

    static int minuteGap(String l, String r) {
        LocalTime left = LocalTime.parse(l);
        LocalTime right = LocalTime.parse(r);
        int rightMinute = right.getHour() * 60 + right.getMinute();
        int leftMinute = left.getHour() * 60 + left.getMinute();
        return rightMinute - leftMinute;
    }
}
