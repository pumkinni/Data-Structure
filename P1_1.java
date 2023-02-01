import java.util.Arrays;
import java.util.PriorityQueue;

public class P1_1 {

    public static int solution(int[][] times, int targetFriend) {

        // 타겟의 시작 시간
        int targetStart = times[targetFriend][0];

        // 시작 시간 기준으로 정렬
        Arrays.sort(times, (x,y) -> x[0] - y[0]);

        PriorityQueue<Integer> chair = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            chair.offer(i);
        }

        // 친구의 종료시간, 의자 번호
        PriorityQueue<int[]> friendChair = new PriorityQueue<>((x,y) -> (x[0] - y[0]));

        for (int i = 0; i < times.length; i++) {

            // 의사를 사용하는 친구의 종료시간이 지금 시간보다 작다면 의자 반납
            while (!friendChair.isEmpty() && friendChair.peek()[0] < times[i][0]){
                chair.add(friendChair.poll()[1]);
            }

            // 타켓이라면 의자번호 출력
            if (targetStart == times[i][0]){
                return chair.poll();
            }

            friendChair.add(new int[]{times[i][1], chair.poll()});
        }

        return 0;
    }

    public static void main(String[] args) {
        // Test code
        int[][] times = {{1, 4}, {2, 3}, {4, 6}};
        System.out.println(solution(times, 1)); // 1

        times = new int[][]{{3, 10}, {1, 5}, {2, 6}};
        System.out.println(solution(times, 0)); // 2
    }
}
