package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2110 {

    static long[] homes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        homes = new long[n];
        for (int i = 0; i < n; i++) {
            homes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(homes);

        int result = -1;

        // 가장 인접한 거리의 탐색 범위
        int left = 1;
        int right = 1000000000;

        while (left <= right) {
            int mid = (left + right) / 2; // 가장 인접한 거리

            if (countConnectors(mid) >= c) { // 원하는 공유기 수보다 많다 -> 거리를 늘려라 && 원하는 공유기 수와 같다 -> 거리를 늘려봐라
                left = mid + 1;
                result = mid;
            } else { // 원하는 공유기 수보다 적다 -> 거리를 줄여라
                right = mid - 1;
            }
        }
        System.out.println(result);
    }

    private static int countConnectors(int distance) { // distance: 가장 인접한 거리
        int count = 1;
        long startPoint = homes[0];
        for (int i = 1; i < homes.length; i++) {
            long endPoint = homes[i];
            if (endPoint - startPoint >= distance) {
                count++;
                startPoint = endPoint;
            }
        }
        return count;
    }
}
