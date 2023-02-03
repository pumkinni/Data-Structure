import java.util.ArrayList;
import java.util.PriorityQueue;

public class P3_Practice3 {

    public static ArrayList<Integer> solution(int k, int[][] customers) {

        ArrayList<Integer> result = new ArrayList<>();

        // 남은 계산대 (작은 순)
        PriorityQueue<Integer> calculTable = new PriorityQueue<>();
        for (int i = 1; i <= k; i++) {
            calculTable.add(i);
        }

        // 계산중인 손님 (시간 작은순 -> 계산대 번호 큰 순)  (손님 번호, 시간, 계산대 번호)
        PriorityQueue<int[]> customer = new PriorityQueue<>((x,y)-> x[1] == y[1] ? y[2] - x[2] : x[1] - y[1]);

        for (int i = 0; i < k; i++) {
            customer.add(new int[]{customers[i][0], customers[i][1], calculTable.poll()});
        }

        int cusIdx = k;
        while (!customer.isEmpty()){

            int[] cur = customer.poll();
            int time = cur[1];
            result.add(cur[0]);
            calculTable.offer(cur[2]);

            while (!customer.isEmpty() && customer.peek()[1] == time){
                cur = customer.poll();
                result.add(cur[0]);
                calculTable.offer(cur[2]);
            }

            while (cusIdx < customers.length && !calculTable.isEmpty()){
                customer.add(new int[]{customers[cusIdx][0], time + customers[cusIdx][1], calculTable.poll()});
                cusIdx++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[][] customers = {{1, 4}, {2, 5}, {3, 14}, {4, 1}, {5, 7}, {6, 5}, {7, 7}, {8, 5}, {9, 10}, {10, 3}};
        System.out.println(solution(3, customers));
    }
}
