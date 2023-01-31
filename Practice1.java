
public class Practice1 {

    static int[][] direct = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    public static boolean solution(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                if (board[i][j] == word.charAt(0)){
                    if (findNext(board, word, j, i, 0, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean findNext(char[][] board, String word, int x, int y, int idx, boolean[][] visited){
        if (idx == word.length()){
            return true;
        }
        if (x >= board[0].length || x < 0 || y >= board.length || y < 0 || visited[y][x] == true){
            return false;
        }

        if (board[y][x] != word.charAt(idx)){
            return false;
        }

        visited[y][x] = true;

        for (int[] dir : direct){
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (findNext(board, word, newX, newY, idx + 1, visited)){
                return true;
            }
        }
        visited[y][x] = false;
        return false;
    }

    public static void main(String[] args) {
        // Test code
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(solution(board, "ABCCED"));
        System.out.println(solution(board, "SEE"));
        System.out.println(solution(board, "ABCB"));
    }
}
