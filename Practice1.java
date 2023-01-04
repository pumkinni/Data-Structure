import java.util.ArrayList;

class MinHeap{
    ArrayList<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(0);
    }

    public void insert(int data) {
        heap.add(data);

        int cur = heap.size() - 1;
        while (cur > 1 && heap.get(cur / 2) > heap.get(cur)) {
            int parentVal = heap.get(cur / 2);
            heap.set(cur / 2, data);
            heap.set(cur, parentVal);

            cur /= 2;
        }
    }

    public Integer delete() {
        if (heap.size() == 1) {
            System.out.println("Heap is empty!");
            return null;
        }

        int target = heap.get(1);

        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int cur = 1;
        while (true) {
            int leftIdx = cur * 2;
            int rightIdx = cur * 2 + 1;
            int targetIdx = -1;

            if (rightIdx < heap.size()) {
                targetIdx = heap.get(leftIdx) < heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if (leftIdx < heap.size()) {
                targetIdx = cur * 2;
            } else {
                break;
            }

            if (heap.get(cur) < heap.get(targetIdx)) {
                break;
            } else {
                int parentVal = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parentVal);
                cur = targetIdx;
            }
        }

        return target;
    }

    public void printTree() {
        for (int i = 1; i < this.heap.size(); i++) {
            System.out.print(this.heap.get(i) + " ");
        }
        System.out.println();
    }
}

// 리스트를 차례로 지나가며 from값을 찾는다.
// from 값을 찾으면 to의 값으로 변경 후
// 1. 변경된 값이 부모 노드보다 크면 부모 노드와 교체 (반복)
// 2. 변경된 값이 자식 노드보다 작으면 자식노드와 교체 (반복)
public class Practice1 {
    public static void solution(MinHeap minHeap, int from, int to) {
        for (int i = 1; i < minHeap.heap.size(); i++) {
            if (minHeap.heap.get(i) == from){
                minHeap.heap.set(i, to);
                minHeap = change(minHeap, i);
            }
        }
    }

    public static MinHeap change(MinHeap minHeap, int idx){
        int curIdx = idx;
        // 1일 경우
        while (curIdx > 1 && minHeap.heap.get(curIdx) < minHeap.heap.get(curIdx / 2)){
            int curData = minHeap.heap.get(curIdx);
            minHeap.heap.set(curIdx, minHeap.heap.get(curIdx/2));
            minHeap.heap.set(curIdx/2, curData);
            curIdx /= 2;
        }

        // 2일 경우
        while (true){
            int leftIdx = curIdx * 2;
            int rightIdx = curIdx * 2 + 1;
            int targetIdx;
            if (rightIdx < minHeap.heap.size()){
                targetIdx = minHeap.heap.get(leftIdx) < minHeap.heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if (leftIdx < minHeap.heap.size()) {
                targetIdx = leftIdx;
            } else {
                break;
            }

            if (minHeap.heap.get(targetIdx) < minHeap.heap.get(curIdx)){
                int curData = minHeap.heap.get(curIdx);
                minHeap.heap.set(curIdx, minHeap.heap.get(targetIdx));
                minHeap.heap.set(targetIdx, curData);
            }
            curIdx = targetIdx;
        }


        return minHeap;
    }

    public static void main(String[] args) {
        // Test code
        MinHeap minHeap = new MinHeap();
        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.insert(10);
        minHeap.insert(50);
        minHeap.insert(60);
        minHeap.insert(70);
        minHeap.insert(20);
        minHeap.insert(30);
        System.out.println("== 데이터 변경 전 ==");
        minHeap.printTree();

        System.out.println("== 데이터 변경 후 ==");
        solution(minHeap, 30, 100);
        minHeap.printTree();

        solution(minHeap, 60, 1);
        minHeap.printTree();
    }
}
