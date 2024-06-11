package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B17141 {

    static int n;
    static int m;
    static String[][] graph;
    static Position[] candidate; // graph 에서 2의 위치들 (사이즈 모름)
    static Position[] firsts; // candidate 에서 추린 확산지 m개
    static int result = 999999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        graph = new String[n][n];
        firsts = new Position[m];
        candidate = new Position[10];
        int candidateIndex = 0;
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                String dot = line[j];
                if (dot.equals("2")) {
                    candidate[candidateIndex++] = new Position(i, j, 0);
                }
            }
            graph[i] = line;
        }

        for (int i = 0; i < 10 && candidate[i] != null; i++) { // candidate 중 m 개를 뽑기
            firsts = new Position[m]; // 확산지 배열 초기화
            chooseVirus(i, 0);
        }

        if (result == 999999) { // result 그대로인 경우: 제대로 된 소요 시간이 없었다 -> 전체 확산 불가능
            System.out.println(-1);
            System.exit(0);
        }
        if (result == -999999) { // result 가 maxTime 의 초깃값인 경우: 소요 시간 계산할 일이 없다 -> 이미 확산된 상태
            System.out.println(0);
            System.exit(0);
        }
        System.out.println(result);
    }

    static void chooseVirus(int nowIndex, int depth) { // candidate 중 m 개의 점 찾기 (dfs)
        firsts[depth] = candidate[nowIndex]; // 하나 선택

        if (depth == m - 1) { // m개가 모두 선택된 경우, 바이러스 전파시키기
            int maxTime = -999999; // 한 번의 전파 당 소요 시간
            Integer[][] visited = new Integer[n][n]; // -1 : 벽, 0 : 확산지, null : 방문 X, 1~ : 방문 O
            spreadVirus(visited); // 전파시키기

            // 전체 visited 를 탐색하면서,
            outer:
            for (int i = 0; i < n; i++) { // 모든 0을 2로 채워야 끝나는 거임! => 아님. 확산지가 아닌 2의 경우도 방문되어야 함! => visited를 체크하자.
                inner:
                for (int j = 0; j < n; j++) {
                    Integer state = visited[i][j];
                    if (state == null) { // 방문되지 않은 위치라면 (하나라도 null 이 있다면 -1 출력하면 됨)
                        maxTime = result;
                        break outer;
                    }
                    if (state == -1) { // 벽이라면
                        continue inner;
                    }
                    if (state == 0) { // 확산지라면
                        continue inner;
                    }
                    maxTime = Math.max(maxTime, state);
                }
            }
            result = Math.min(maxTime, result);
            return;
        }
        for (int next = nowIndex + 1; next < 10 && candidate[next] != null; next++) {
            chooseVirus(next, depth + 1);
        }
    }

    static void spreadVirus(Integer[][] visited) { // 확산시키기 + 소요 시간 구하기 (bfs)
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        Queue<Position> queue = new LinkedList<>();

        // graph 전체 탐색하면서 벽이면 visited 에 -1 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j].equals("1")) {
                    visited[i][j] = -1;
                }
            }
        }

        // 모든 확산지에 대해서 visited 에 0 저장 + 큐에 삽입
        for (Position first : firsts) {
            visited[first.x][first.y] = 0;
            queue.offer(first); // m개 삽입
        }

        // bfs
        while (!queue.isEmpty()) {
            Position now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                // TODO: 확산지를 방문하면 어떻게 되는 거지?
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] != null) { // 범위 밖이거나 벽이거나, 이미 방문한 곳이라면 (+ 이거나 확산지라면)
                    continue;
                }
                visited[nx][ny] = now.count + 1; // 방문 처리 및 시간 저장
                queue.offer(new Position(nx, ny, now.count + 1)); // 큐에 저장
            }
        }
    }

    static class Position {
        int x;
        int y;
        int count;

        Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Position{" +
                   "x=" + x +
                   ", y=" + y +
                   ", count=" + count +
                   '}';
        }
    }
}
