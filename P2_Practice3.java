import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P2_Practice3 {
    public static boolean solution(int[] target) {
        int[] nums = new int[target.length];

        Arrays.sort(target);

        String tar = Arrays.toString(target);

        for (int i = 0; i < target.length; i++) {
            nums[i] = 1;
        }

        Queue<int[]> queue = new LinkedList<>();

        queue.add(nums);


        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll().clone();
                String c = Arrays.toString(cur);
                if (c.equals(tar)){
                    return true;
                }
                int sum = Arrays.stream(cur).sum();

                for (int j = 0; j < cur.length; j++) {
                    if (cur[j] < target[j]){
                        int num = cur[j];
                        cur[j] = sum;
                        queue.add(cur.clone());
                        cur[j] = num;
                    }
                }
            }
        }
        return false;
    }



    public static void main(String[] args) {
        // Test code
        int[] target = {9, 3, 5};
        System.out.println(solution(target));

        target = new int[]{8, 5};
        System.out.println(solution(target));

        target = new int[]{1, 1, 1, 2};
        System.out.println(solution(target));
    }
}
