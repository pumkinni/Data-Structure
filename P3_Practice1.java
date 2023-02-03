
public class P3_Practice1 {
    static int[][] direct = new int[][]{{-1, 0}, {0,1} , {1,0}, { 0,-1}};

    public static void solution(char[][] picture) {
        int cntC = 0;
        int cnt = 0;
        int[][] nomal = new int[picture.length][picture[0].length];
        int[][] notNomal = new int[picture.length][picture[0].length];
        // dfs를 이용해 구분 하기
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (nomal[i][j] == 0){
                    cnt ++ ;
                    dfs(picture, nomal, i, j, picture[i][j]);
                }
                if (notNomal[i][j] == 0){
                    cntC ++;
                    dfsC(picture, notNomal, i, j, picture[i][j]);
                }
            }
        }
        System.out.println(cnt);
        System.out.println(cntC);
    }

    public static void dfs(char[][] picture, int[][] visited, int x, int y, char color){
        if (x < 0 || y<0 || x >= picture.length || y >= picture[0].length){
            return ;
        }

        if (visited[x][y] != 0){
            return ;
        }

        if (picture[x][y] != color){
                return ;
        }

        visited[x][y] = 1;

        for (int[] dir : direct){
            int newX = dir[0] + x;
            int newY = dir[1] + y;

            dfs(picture, visited, newX, newY, color);
        }
    }

    public static void dfsC(char[][] picture, int[][] visited, int x, int y, char color){
        if (x < 0 || y<0 || x >= picture.length || y >= picture[0].length){
            return ;
        }

        if (visited[x][y] != 0){
            return ;
        }

        if (color == 'B'){
            if (picture[x][y] != color){
                return ;
            }
        }


        if (color == 'R' || color == 'G'){
            if (picture[x][y] == 'B'){
                return ;
            }
        }

        visited[x][y] = 1;

        for (int[] dir : direct){
            int newX = dir[0] + x;
            int newY = dir[1] + y;

            dfsC(picture, visited, newX, newY, color);
        }
    }

    public static void main(String[] args) {
        // Test code
        char[][] pictures = {{'R', 'R', 'R', 'B', 'B'}, {'G', 'G', 'B', 'B', 'B'}, {'B', 'B', 'B', 'R', 'R'},
                {'B', 'B', 'R', 'R', 'R'}, {'R', 'R', 'R', 'R', 'R'}};
        solution(pictures); // 4 3
        pictures = new char[][]{{'R', 'R', 'R', 'B', 'B'}, {'G', 'G', 'B', 'B', 'B'}, {'R', 'R', 'B', 'R', 'R'},
                {'B', 'B', 'R', 'R', 'R'}, {'R', 'R', 'R', 'R', 'R'}};
        solution(pictures); // 4 3
    }
}
