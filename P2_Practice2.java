import java.util.Arrays;

public class P2_Practice2 {
    public static int[] solution(int[][] intervals, int[] queries) {
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int cur = queries[i];
            int minCnt = Integer.MAX_VALUE;
            int cnt = 0;
            for (int j = 0; j < intervals.length; j++) {
                if (intervals[j][0] <= cur && intervals[j][1] >= cur){
                    cnt = intervals[j][1] - intervals[j][0] + 1;
                    minCnt = Math.min(cnt, minCnt);
                }
            }

            if (minCnt == Integer.MAX_VALUE){
                result[i] = -1;
            } else {
                result[i] = minCnt;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[][] intervals = {{1, 4}, {2, 4}, {3, 6}, {4, 4}};
        int[] queries = {2, 3, 4, 5};
        System.out.println(Arrays.toString(solution(intervals, queries)));

        intervals = new int[][]{{2, 3}, {2, 5}, {1, 8}, {20, 25}};
        queries = new int[]{2, 19, 5, 22};
        System.out.println(Arrays.toString(solution(intervals, queries)));
    }
}
