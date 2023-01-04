// 입력: 3 0 -2 -5 9 6 -11, 20, -30
// 삭제 횟수: 1
// 출력: 20, -11 9 6 -5 3 -2 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 최소힙 자료구조에 값을 추가하고 n번 삭제 후 모든 값들을 절댓값으로 바꾸어 새로운 최대힙 자료구조에 넣는다.
// 내림차순으로 정렬하여 출력할 때 원래 배열에 있던 숫자면 그대로 출력, 없으면 음수로 출력한다.
public class Practice3 {
    public static void solution(int[] nums, int deleteCnt) {
        MinHeap minHeap = new MinHeap();
        MaxHeap maxHeap = new MaxHeap();
        ArrayList list = new ArrayList();
        for (int num: nums) {
            minHeap.insert(num);
        }
        for (int i = 0; i < deleteCnt; i++) {
            minHeap.delete();
        }
        while (minHeap.heap.size() != 1){
            int data = minHeap.delete();
            maxHeap.insert(Math.abs(data));
            list.add(data);
        }
        while (maxHeap.heap.size() != 1){
            int data = maxHeap.delete();
            if (list.contains(data)){
                System.out.print(data + " ");
            }else {
                System.out.print(-data + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test code
        int nums[] = {3, 0, -2, -5, 9, 6, -11, 20, -30};
        int deleteCnt = 1;
        solution(nums, deleteCnt);
    }
}
