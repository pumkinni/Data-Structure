import java.util.*;

public class Practice4 {
    public static int solution(int n, int[] speed, int[] efficiency, int k) {

        // value : speed, key : efficiency
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < speed.length; i++) {
            map.put(efficiency[i], speed[i]);
        }

        System.out.println(map);


        List<Integer> list = new LinkedList<>();
        Arrays.stream(speed).boxed().mapToInt(i -> i).forEach(i -> list.add(i));

        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);




        Arrays.sort(efficiency);

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n - k + 1; i++) {
            int eff = efficiency[i];
            int sum = map.get(eff);
            list.remove(Integer.valueOf(sum));
            System.out.println(list.size());
            for (int j = 0; j < k-1; j++) {
                sum += list.get(j);
            }
            max = Math.max(max, sum * eff);
        }

        return max;
    }

    public static void main(String[] args) {
        // Test code
        int[] speed = {2, 10, 3, 1, 5, 8};
        int[] efficiency = {5, 4, 3, 9, 7, 2};
        System.out.println(solution(6, speed, efficiency, 2));
        speed = new int[]{2, 10, 3, 1, 5, 8};
        efficiency = new int[]{5, 4, 3, 9, 7, 2};
        System.out.println(solution(6, speed, efficiency, 3));
        speed = new int[]{2, 10, 3, 1, 5, 8};
        efficiency = new int[]{5, 4, 3, 9, 7, 2};
        System.out.println(solution(6, speed, efficiency, 4));
    }
}
