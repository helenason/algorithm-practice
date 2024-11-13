package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B23254 {

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringTokenizer st_a = new StringTokenizer(br.readLine());
        StringTokenizer st_b = new StringTokenizer(br.readLine());
        PriorityQueue<Component> components = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(st_a.nextToken());
            int b = Integer.parseInt(st_b.nextToken());
            result += a;
            components.add(new Component(b, 100 - a));
        }

        int totalHour = 24 * n;
        while (totalHour > 0 && !components.isEmpty()) {
            Component component = components.poll();
            int scorePerHour = component.scorePerHour;
            int remainScore = component.remainScore;
            if (totalHour < remainScore / scorePerHour) {
                result += totalHour * scorePerHour;
                totalHour = 0;
                continue;
            }
            if (remainScore % scorePerHour == 0) {
                totalHour -= remainScore / scorePerHour;
                result += remainScore;
            } else {
                totalHour -= remainScore / scorePerHour;
                result += scorePerHour * (remainScore / scorePerHour);
                components.add(new Component(remainScore % scorePerHour, remainScore % scorePerHour));
            }
        }

        System.out.println(result);
    }

    static class Component implements Comparable<Component> {

        int scorePerHour;
        int remainScore;

        Component(int scorePerHour, int remainScore) {
            this.scorePerHour = scorePerHour;
            this.remainScore = remainScore;
        }

        @Override
        public int compareTo(Component component) {
            return component.scorePerHour - this.scorePerHour;
        }
    }
}
