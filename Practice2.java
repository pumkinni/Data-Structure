
// (1)최대힙에 입력을 넣고 (2)가장 큰 수 두개를 꺼내어 값을 비교
// 소멸되면 (2) 반복, 남으면 힙에 값 추가 후 (2) 반복
// 힙의 size가 1개일때까지 반복

import java.util.Collections;
import java.util.PriorityQueue;

public class Practice2 {
    public static void solution(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone: stones){
            pq.offer(stone);
        }
        while (pq.size() > 1){
            int stone1 = pq.poll();
            int stone2 = pq.poll();

            if (stone1 != stone2){
                pq.offer(Math.abs(stone1 - stone2));
            }
        }
        System.out.println(pq.poll());
    }

    public static void main(String[] args) {
        // Test code
        int[] stones = {2, 7, 4, 1, 8, 1};
        solution(stones);

        stones = new int[]{5, 3, 5, 3, 4};
        solution(stones);
    }
}
