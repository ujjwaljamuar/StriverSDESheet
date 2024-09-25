import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q6_NMeetingsRoom {
    int maxMeetings(int start[], int end[], int n) {
        List<Meeting> meets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            meets.add(new Meeting(start[i], end[i], i + 1));
        }

        MeetingComparator mc = new MeetingComparator();

        Collections.sort(meets, mc);

        List<Integer> answer = new ArrayList<>();

        answer.add(meets.get(0).pos);

        int limit = meets.get(0).end;

        for (int i = 1; i < start.length; i++) {
            if (meets.get(i).start > limit) {
                limit = meets.get(i).end;
                answer.add(meets.get(i).pos);
            }
        }

        System.out.println("The order in which the meetings will be performed is ");
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }

        return answer.size();
    }

    public static void main(String[] args) {
        Q6_NMeetingsRoom grd = new Q6_NMeetingsRoom();

        int n = 6;
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 5, 7, 9, 9 };
        System.out.println(grd.maxMeetings(start, end, n));
    }

    class Meeting {
        int start;
        int end;
        int pos;

        Meeting(int _start, int _end, int _pos) {
            this.start = _start;
            this.end = _end;
            this.pos = _pos;
        }
    }

    class MeetingComparator implements Comparator<Meeting> {

        @Override
        public int compare(Meeting o1, Meeting o2) {
            if (o1.end < o2.end)
                return -1;
            else if (o1.end > o2.end)
                return 1;
            else if (o1.pos < o2.pos)
                return -1;
            return 1;
        }
    }
}
