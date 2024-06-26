package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class B7576 {

    static int[][] graph;
    static List<Position> queue;
    static int count = 0;
    static int notDone = 0;
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        graph = new int[N][M];

        // initialize
        queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" "); // M개
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(row[j]);
                graph[i][j] = value;
                if (value == 0) {
                    notDone++;
                }
                if (value == 1) {
                    queue.add(new Position(i, j));
                }
            }
        }

        move();

        if (notDone > 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(count);
    }

    static void move() {
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{-1, 1, 0, 0};

        while (!queue.isEmpty()) {
            List<Position> nexts = new ArrayList<>();
            for (Position now : queue) {
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && graph[nx][ny] == 0) {
                        graph[nx][ny] = 1;
                        nexts.add(new Position(nx, ny));
                        notDone--;
                    }
                }
            }
            queue = nexts;
            if (!nexts.isEmpty()) {
                count++;
            }
        }
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
