
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Practice3 {
    public static void solution1(int[] nums, int k) {
        // 빈도수가 같으면 k값이 작은거 먼저, 다르면 value 값이 큰거 먼저
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((x,y)->
                x.getValue() == y.getValue() ? x.getKey() - y.getKey() : y.getValue() - x.getValue());
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer,Integer> item : map.entrySet()){
            pq.offer(item);
        }

        for (int i = 0; i < k; i++) {
            System.out.print(pq.poll().getKey());
        }
    }

    // class를 생성하여 우선순위 정하기
    public static void solution2(int[] nums, int k) {

    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {1, 1, 1, 2, 2, 3};
        solution1(nums, 2);
        solution2(nums, 2);
        System.out.println();

        nums = new int[]{3, 1, 4, 4, 3, 3, 1, 2, 2, 1, 3};
        solution1(nums, 3);
        solution2(nums, 3);
    }
}
