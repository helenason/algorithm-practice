package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B3020 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 너비: 2 ~ 200,000
        int h = Integer.parseInt(input[1]); // 높이: 2 ~ 500,000
        int[] downs = new int[n / 2]; // 아래 장애물
        int[] ups = new int[n / 2]; // 위 장애물
        for (int i = 0; i < n / 2; i++) {
            downs[i] = Integer.parseInt(br.readLine());
            ups[i] = h - Integer.parseInt(br.readLine());
        }

        Arrays.sort(downs);
        Arrays.sort(ups);

        int min = 200001;
        int resultCount = 0;
        for (int target = 1; target <= h; target++) {
            int upConflict = countConflictUps(ups, target);
            int downConflict = countConflictDowns(downs, target);
            int conflictCount = upConflict + downConflict;
            if (min > conflictCount) {
                min = conflictCount;
                resultCount = 1;
            } else if (min == conflictCount) {
                resultCount++;
            }
        }
        System.out.println(min + " " + resultCount);
    }

    static int countConflictDowns(int[] downs, int target) {
        int left = 0;
        int right = downs.length - 1;

        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (downs[mid] >= target) { // 충돌
                right = mid - 1; // 왼쪽으로 땡겨
                result = mid; // 충돌나는 애들 중 가장 왼쪽
            } else { // 충돌 X
                left = mid + 1; // 오른쪽으로 땡겨
            }
        }
        if (result == -1) { // 모두 충돌 X
            return 0;
        }
        return downs.length - result;
    }

    static int countConflictUps(int[] ups, int target) {
        int left = 0;
        int right = ups.length - 1;

        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (ups[mid] < target) { // 충돌
                left = mid + 1; // 오른쪽으로 땡겨
                result = mid; // 충돌나는 애들 중 가장 오른쪽
            } else { // 충돌 X
                right = mid - 1; // 왼쪽으로 땡겨
            }
        }
        if (result == -1) { // 모두 충돌 X
            return 0;
        }
        return result + 1; // 충돌 개수
    }

    static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}
