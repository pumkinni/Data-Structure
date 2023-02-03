
public class P3_Practice2 {
    static boolean[][] light;
    static int[][] direct = new int[][]{{-1,0}, {0,1}, {0,-1}, {1,0}};
    public static int solution(int n, int[][] switches) {
        light = new boolean[n][n];

        light[0][0] = true;
        boolean isChange = true;
        int cnt = 1;

        while (isChange) {
            isChange = false;

            for (int[] swi : switches) {
                boolean[][] visited = new boolean[n][n];
                int x = swi[0] - 1;
                int y = swi[1] - 1;
                int nextX = swi[2] - 1;
                int nextY = swi[3] - 1;

                if (light[nextX][nextY]){
                    continue;
                }

                if (dfs(x, y, nextX, nextY, visited)) {
                    cnt ++;
                    isChange = true;
                }
            }
        }
        return cnt;
    }

    public static boolean dfs(int x, int y, int nextX, int nextY, boolean[][] visited){
        if (x < 0 || y< 0 || x >= light.length || y >= light[0].length){
            return false;
        }

        if (visited[x][y]){
            return false;
        }

        if (light[nextX][nextY] == true){
            return false;
        }

        if (x == nextX && nextY == y){
            light[x][y] = true;
            return true;
        }

        if (light[x][y] == false){
            return false;
        }

        visited[x][y] = true;

        for (int[] dir : direct){
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (dfs(newX, newY, nextX, nextY, visited)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Test code
        int[][] switches = {{1, 1, 1, 2}, {2, 1, 2, 2}, {1, 1, 1, 3}, {2, 3, 3, 1}, {1, 3, 1, 2}, {1, 3, 2, 1}, {1,3,3,3}};
        System.out.println(solution(3, switches));  // 5
    }
}
