// 방법 1
// 보드를 돌면서 o를 찾는다. 찾은 o를 사방으로 돌며 따라 가며, 가는 o중 하나라도 벽에 붙어 있으면 o로 두고,
// 아니라면 다 x로 둔다.
// 그 다음 o를 찾는다.
// 끝이 있다면 'O', 없으면 'X'로 두어야하므로 시작의 위치에 번호를 부여하여 끝이 있는지 없는지 저장해두기

// 방법 2
// 보드의 외각을 돌며 'O'를 발견하면 dfs를 진행한다. -> 훨신 간편

import java.util.HashMap;

public class NLPractice2 {
    static int[][] direction = {{-1, 0},{0,1},{1,0},{0,-1}};
    public static void solution(char[][] board) {
        int[][] visited = new int[board.length][board[0].length];
        HashMap<Integer, Character> checkChar = new HashMap<>();
        int idx = 1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && visited[i][j] == 0){
                    checkChar.put(idx, 'X');
                    visited[i][j] = idx;
                    findNext(i, j, board, visited, idx, checkChar);
                    idx ++;
                }

            }
        }

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                int key = visited[i][j];
                if (checkChar.containsKey(key)){
                    board[i][j] = checkChar.get(key);
                }
            }
        }

    }

    public static void findNext(int x, int y, char[][] board, int[][] visited, int idx, HashMap checkChar){

        // 해당 위치가 끝인지 확인
        if (x == 0 || x == board.length - 1 || y == 0 || y == board[0].length - 1){
            checkChar.put(idx, 'O');
        }

        // 해당위치 위,아래,오른쪽, 왼쪽을 돌며 'O'를 찾기
        for (int[] direct : direction){
            int nextX = x + direct[0];
            int nextY = y + direct[1];


            if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length){
                continue;
            }

            if (board[nextX][nextY] == 'O' && visited[nextX][nextY] == 0){
                visited[nextX][nextY] = idx;
                findNext(nextX, nextY, board, visited, idx, checkChar);
            }
        }
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
        System.out.println();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
