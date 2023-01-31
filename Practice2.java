import java.util.HashMap;
import java.util.Map;

public class Practice2 {
    public static int[][] direct = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
    public static Map<Integer, Character> OX = new HashMap<>();
    public static void solution(char[][] board) {

        int[][] visited = new int[board.length][board[0].length];
        OX.put(-1, 'O');
        OX.put(0, 'X');

        int num = 1;
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'O' && visited[i][j] == 0){
                    OX.put(num, 'X');
                    checkNum(board, num, i, j, visited);
                    num ++;
                }
            }
        }

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                board[i][j] = OX.get(visited[i][j]);
            }
        }
    }

    public static boolean checkNum(char[][] board, int num, int x, int y, int[][] visited){
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length){
            return false;
        }

        if (board[x][y] == 'X'){
            return false;
        }
        if (visited[x][y] != 0){
            return true;
        }

        if (x == 0 || y == 0 || x == board.length - 1 || y == board[0].length){
            OX.replace(num, 'O');
        }

        visited[x][y] = num;

        int cnt = 0;

        for (int[] dir : direct){
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (checkNum(board, num, newX, newY, visited)){
                cnt ++;
            }
        }

        if (cnt == 4){
            visited[x][y] = -1;
        }

        return true;
    }

    public static void main(String[] args) {
        // Test code
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        solution(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'O', 'X'}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        solution(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        board = new char[][]{{'X', 'X', 'X', 'X','X'}, {'X', 'O', 'O', 'O','X'}, {'X', 'O', 'O', 'O','X'}, {'X', 'O', 'O', 'O','X'}, {'X', 'X', 'X', 'X','X'}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        solution(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
