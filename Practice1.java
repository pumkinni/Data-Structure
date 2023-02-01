import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Practice1 {
    public static int solution(int[][] times, int targetFriend) {
        PriorityQueue<Integer> chair = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            chair.add(i);
        }

        // 사람과 의자 정보
        Map<Integer, Integer> map = new HashMap<>();
        int time = 0;
        while (true){
            for (int i = 0; i < times.length; i++) {
                if (times[i][0] == time){
                    if (i == targetFriend){
                        return chair.poll();
                    }
                    map.put(i, chair.poll());
                }
                if (times[i][1] == time){
                    chair.offer(map.get(i));
                }
            }
            time ++;
        }
    }

    public static void main(String[] args) {
        // Test code
        int[][] times = {{1, 4}, {2, 3}, {4, 6}};
        System.out.println(solution(times, 1)); // 1

        times = new int[][]{{3, 10}, {1, 5}, {2, 6}};
        System.out.println(solution(times, 0)); // 2
    }
}
