import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Practice5 {
    private static class Node{
        int num;
        boolean isMinus;

        public Node(int num, boolean isMinus) {
            this.num = num;
            this.isMinus = isMinus;
        }
    }
    public static int solution(int[] forbidden, int a, int b, int x) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, false));

        int cnt = 0;
        Set<Integer> visited = new HashSet<>();

        for (int i : forbidden){
            visited.add(i);
        }

        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();

                if (cur.num < 0){
                    continue;
                }

                if (visited.contains(cur.num)){
                    continue;
                }

                if (cur.num == x){
                    return cnt;
                }

                if (cur.num - 2*b > x ){
                    continue;
                }

                if (cur.isMinus){
                    queue.add(new Node(cur.num + a, false));
                } else {
                    queue.add(new Node(cur.num + a, false));
                    queue.add(new Node(cur.num - b, true));
                }
            }
            cnt ++;
        }
        return -1;
    }

    public static void main(String[] args) {
        // Test code
        int[] forbidden = {14, 4, 18, 1, 15};
        System.out.println(solution(forbidden, 3, 15, 9));

        forbidden = new int[]{8, 3, 16, 6, 12, 20};
        System.out.println(solution(forbidden, 15, 13, 11));

        forbidden = new int[]{1, 6, 2, 14, 5, 17, 4};
        System.out.println(solution(forbidden, 16, 9, 7));
    }
}
