package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B1697 {

    static List<Path> queue = new ArrayList<>();
    static boolean[] visited = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        bfs(start, end);
    }

    static void bfs(int start, int end) {
        queue.add(new Path(start, 0));
        while (!queue.isEmpty()) {
            Path now = queue.remove(0);
            if (now.position == end) {
                System.out.println(now.order);
                break;
            }
            move(now.position + 1, now.order);
            move(now.position - 1, now.order);
            move(now.position * 2, now.order);
        }
    }

    static void move(int to, int nowOrder) {
        if (to >= 0 && to <= 100000 && !visited[to]) {
            queue.add(new Path(to, nowOrder + 1));
            visited[to] = true;
        }
    }

    static class Path {
        int position;
        int order;

        public Path(int position, int order) {
            this.position = position;
            this.order = order;
        }
    }
}
