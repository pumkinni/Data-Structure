
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// 각 문자의 문자와 개수를 저장
// (1)가장 많은 문자를 출력하고 개수 -1
// (2)출력한 문자 제외 가장 많은 문자를 출력, 개수 -1
// (2)를 반복하여, 다른 문자가 남지 않았을 때 출력한 문자만 남아있다면 null, 아니면 다 출력


public class PriorityQueuePractice4 {
    public static String solution(String s) {
        StringBuffer result = new StringBuffer();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((x,y) -> y.getValue() - x.getValue());
        HashMap<String, Integer> map = new HashMap<>();
        // 각 문자의 개수를 map에 저장
        for (String str: s.split("")) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        // 맵의 각 엔트리를 최대힙에 저장
        for (Map.Entry<String,Integer> item : map.entrySet()){
            pq.offer(item);
        }

        Map.Entry<String,Integer> prev = null ;
        while (result.length() != s.length()){
            Map.Entry<String, Integer> cur = pq.poll();

            if (prev != null && prev.getValue() != 0){
                pq.offer(prev);
            }

            result.append(cur.getKey());
            cur.setValue(cur.getValue() - 1);
            prev = cur;

            if (prev.getValue() != 0 && pq.isEmpty()){
                return null;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution("aabb"));
        System.out.println(solution("aaaaabccd"));
        System.out.println(solution("aaca"));
    }
}
