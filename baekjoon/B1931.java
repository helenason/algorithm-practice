package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class B1931 {

    private static final List<Meeting> meetings = new ArrayList<>();
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            meetings.add(new Meeting(start, end));
        }

        // 끝 시간 -> 시작 시간 기준 정렬
        meetings.sort(Comparator.comparing(meeting -> meeting.start));
        meetings.sort(Comparator.comparing(meeting -> meeting.end));

        count++;
        Meeting selected = meetings.get(0);
        for (int i = 1; i < meetings.size(); i++) {
            Meeting tmp = meetings.get(i);
            if (selected.end <= tmp.start) {
                count++;
                selected = tmp;
            }
        }

        System.out.println(count);
    }
}

class Meeting {

    final int start;
    final int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
