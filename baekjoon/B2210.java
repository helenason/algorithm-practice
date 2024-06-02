package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class B2210 {

    static String[][] graph = new String[5][5];
    static Set<String> result = new HashSet<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String[] line = br.readLine().split(" ");
            graph[i] = line;
        }

        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                dfs(x, y, 0, graph[x][y]);
            }
        }
        System.out.println(result.size());
    }

    private static void dfs(int x, int y, int count, String tmp) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) {
                continue;
            }
            if (count > 5) {
                continue;
            }
            if (count == 5) {
                result.add(tmp);
                continue;
            }
            dfs(nx, ny, count + 1, tmp + graph[nx][ny]);
        }
    }
}
