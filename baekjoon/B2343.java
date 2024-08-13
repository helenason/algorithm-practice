package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2343 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[] lectures = new int[n];
        long sum = 0;
        String[] rawLectures = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            lectures[i] = Integer.parseInt(rawLectures[i]);
            sum += lectures[i];
        }

        long left = 1;
        long right = sum;
        long result = -1;

        while (left <= right) {
            long mid = (left + right) / 2;

            int cal = 1; // mid로 나뉘지 않을 수도 있다는 것 적용하기
            long tmp = 0;
            for (int lecture : lectures) {
                tmp += lecture;
                if (tmp > mid) {
                    cal++;
                    if (lecture > mid) {
                        cal = 100001; // m보다 무조건 크게
                        continue;
                    }
                    tmp = lecture;
                }
            }

            if (cal > m) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
