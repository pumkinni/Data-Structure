// 방법1
// nums 배열의 수를 우선순위 큐에 큰수부터 넣는다.
// 하나씩 제거하며 k번째 수를 반환한다.

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Practice1 {
    public static int solution1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int result = 0;
        for (int num:nums){
            pq.offer(num);
        }
        for (int i = 0; i < k; i++) {
            result = pq.poll();
        }

        return result;
    }

    public static int solution2(int[] nums, int k) {
        Arrays.sort(nums);


        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {3, 1, 2, 7, 6, 4};
        System.out.println(solution1(nums, 2));
        System.out.println(solution2(nums, 2));
        System.out.println();

        nums = new int[]{1, 3, 7, 4, 2, 8, 9};
        System.out.println(solution1(nums, 7));
        System.out.println(solution2(nums, 7));
    }
}