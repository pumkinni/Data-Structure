// 방법 1
// 1. 단어의 각 스펠의 보드의 위치(x,y)를 찾는다.
// 2-1. 다음 스펠이 전 스펠의 위치와 x나 y가 (상황1)+1 or -1이라면 계속 진행,
// 해당 위치가 사용되었음을 기록하는 배열에 1를 입력
// 2-2. 전 스펠과의 위치가 (상황1)이 아니면
// 스펠의 다른 위치를 찾아서 반복
// 끝까지 없으면 앞의 스펠이 다른 위치가 있는지 확인 -> 재귀
// -> 재귀를 구현하려고 하니 코드가 너무 복잡해져서 포기

// 방법2
// 또는 그래프 -> 노드 수가 많고 간선수가 적기때문에 인접 리스트 이용

// 방법3
// DFS를 이용하여 시작 단어를 찾고 위,아래, 오른쪽, 왼쪽으로 돌며 다음 스펠링을 찾아 이동 -> 이동후 방문 표시



public class NLPractice1 {

    public static boolean solution(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];
        int[] cur = new int[2];
        char c = word.charAt(0);
        int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        // 시작단어 위치 찾기
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == c) {
                    cur[0] = i;
                    cur[1] = j;
                    visited[i][j] = 1;
                    if (findNext(word, direction, board, visited,cur, 1)){
                        return true;
                    }
                    visited[i][j] = 0;
                }
            }

            }
        return false;
    }

    static boolean findNext(String word, int[][] direction, char[][] board,int[][] visited, int[] cur, int idx ){
        if (idx == word.length()){
            return true;
        }
        char c = word.charAt(idx);
        for (int[] direct: direction) {
            int x = cur[0] + direct[0];
            int y = cur[1] + direct[1];

            if (x>=0 && x < board.length && y >=0 && y < board[0].length && board[x][y] == c && visited[x][y] == 0){
                int[] next = {x,y};
                visited[x][y] = 1;
                if (findNext(word, direction, board, visited, next, idx + 1)){
                    return true;
                } else {
                    visited[x][y] = 0;
                }
            }
        }
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
