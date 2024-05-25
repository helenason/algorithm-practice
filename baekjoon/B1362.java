package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1362 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = 0;

        while (true) {
            String weightsInput = br.readLine();
            if (weightsInput.equals("0 0")) {
                break;
            }
            count++;
            String[] weightsInputArr = weightsInput.split(" ");
            int safeWeight = Integer.parseInt(weightsInputArr[0]);
            int nowWeight = Integer.parseInt(weightsInputArr[1]);

            boolean isDead = false;
            while (true) {
                String actionInput = br.readLine();
                if (actionInput.equals("# 0")) {
                    break;
                }
                String[] actionInputArr = actionInput.split(" ");
                String action = actionInputArr[0];
                int range = Integer.parseInt(actionInputArr[1]);

                if (!isDead && action.equals("F")) {
                    nowWeight += range;
                }
                if (!isDead && action.equals("E")) {
                    nowWeight -= range;
                    if (nowWeight <= 0) {
                        isDead = true;
                    }
                }
            }

            if (nowWeight <= 0) {
                sb.append(count);
                sb.append(" ");
                sb.append("RIP\n");
            } else if (safeWeight / 2 < nowWeight && nowWeight < safeWeight * 2) {
                sb.append(count);
                sb.append(" ");
                sb.append(":-)\n");
            } else {
                sb.append(count);
                sb.append(" ");
                sb.append(":-(\n");
            }
        }
        System.out.println(sb);
    }
}
