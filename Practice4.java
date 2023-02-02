import java.util.*;

public class Practice4 {
    static int min = Integer.MAX_VALUE;
    public static int solution(String[] deadends, String target) {

        if (target.length() != 4 || target == null){
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add("0000");

        HashSet<String> visited = new HashSet<>(Arrays.asList(deadends));

        int cnt = 0;

        while (!queue.isEmpty()){
            int size = queue.size();
            // 지금까지의 큐 데이터에서 추출
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();

                if (target.equals(cur)){
                    return cnt;
                }

                if (visited.contains(cur)){
                    continue;
                }

                for (String s: findNext(cur.toCharArray())){
                    if (!visited.contains(s)) {
                        queue.add(s);
                    }
                }
            }
            cnt ++;

        }
        return -1;
    }

    public static ArrayList<String> findNext(char[] nums){
        ArrayList<String> list = new ArrayList<>();
        char[] cur = nums.clone();

        for (int i = 0; i < nums.length; i++) {
            char c = cur[i];
            cur[i] = c == '9' ? '0' : (char)((int)c + 1);
            list.add(String.valueOf(cur));
            cur[i] = c;

            cur[i] = c == '0' ? '9' : (char)((int)c - 1);
            list.add(String.valueOf(cur));
            cur[i] = c;
        }

        return list;
    }

    public static void main(String[] args) {
        // Test code
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        System.out.println(solution(deadends, "0202"));

        deadends = new String[] {"8888"};
        System.out.println(solution(deadends, "0009"));

    }
}
