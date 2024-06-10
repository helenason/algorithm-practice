package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class B9205 {

    static Position home;
    static Position destination;
    static Position[] conveniences;
    static Set<Position> visited;
    static boolean isArrived;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int round = 0; round < t; round++) {
            int n = Integer.parseInt(br.readLine());
            String[] rawHome = br.readLine().split(" ");
            home = new Position(Integer.parseInt(rawHome[0]), Integer.parseInt(rawHome[1]));
            conveniences = new Position[n];
            for (int i = 0; i < n; i++) {
                String[] rawConvenience = br.readLine().split(" ");
                conveniences[i] = new Position(Integer.parseInt(rawConvenience[0]), Integer.parseInt(rawConvenience[1]));
            }
            String[] rawDestination = br.readLine().split(" ");
            destination = new Position(Integer.parseInt(rawDestination[0]), Integer.parseInt(rawDestination[1]));

            visited = new HashSet<>();
            isArrived = false;
            dfs(home);
            if (isArrived) {
                sb.append("happy");
            } else {
                sb.append("sad");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(Position now) { // 갔는데 길이 막혀있으면 돌아와서 다른 길 찾아야 함 -> 바로 리턴해버리면 안 됨
        visited.add(now);
        if (distance(now, destination) <= 1000) { // 현재 위치로부터 목적지에 다다를 수 있으면
            isArrived = true;
            return;
        }
        for (Position next : conveniences) {
            if (!visited.contains(next) && distance(now, next) <= 1000) {
                // 방문 한 적 없고, 갈 수 있는 거리라면
                dfs(next);
            }
        }
    }

    static int distance(Position from, Position to) {
        return Math.abs(to.x - from.x) + Math.abs(to.y - from.y);
    }

    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
