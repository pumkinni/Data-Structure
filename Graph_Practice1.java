
// 입력 그래프: {{1, 2}, {2, 3}, {4, 2}}
// 출력: 2

// 입력 그래프: {{1,2}, {5,1}, {1,3}, {1,4}}
// 출력: 1

import java.util.HashSet;
import java.util.Set;

class MyGraphMatrix {
    char vertices[];
    int[][] adjMat;
    int elemCnt;

    public  MyGraphMatrix() {}
    public MyGraphMatrix(int size) {
        this.vertices = new char[size];
        this.adjMat = new int[size][size];
        this.elemCnt = 0;
    }

    public boolean isFull() {
        return this.elemCnt == this.vertices.length;
    }

    public void addVertex(char data) {
        if (isFull()) {
            System.out.println("Graph is full!");
            return;
        }

        this.vertices[this.elemCnt++] = data;
    }

    public void addEdge(int x, int y) {
        this.adjMat[x][y] = 1;
        this.adjMat[y][x] = 1;
    }
}

// 무방향 그래프에 각 엣지를 설정하여
// 인접 행열에서 열이 모두 1인 행을 찾기

public class Practice1 {
    public static int solution(int[][] e) {
        MyGraphMatrix graph = new MyGraphMatrix(e.length + 1);
        for (int[] edge:e) {
            graph.addEdge(edge[0]-1, edge[1]-1);
        }

        for (int i = 0; i < graph.adjMat.length; i++) {
            int edgeCnt = 0;
            for (int j = 0; j < graph.adjMat[0].length; j++) {
                if (graph.adjMat[i][j] == 1){
                    edgeCnt ++;
                }
            }
            if (edgeCnt == graph.adjMat.length - 1){
                return i + 1;
            }
        }
        return 0;
    }

    // 간선의 총 개수는 노드의 개수 -1
    // 모든 노드는 연결되어있다 라는 조건이 있다면
    public static int solution2(int[][] e) {
        return e[0][0] == e[1][0] || e[0][0] == e[1][1] ? e[0][0] : e[0][1];
    }

    public static void main(String[] args) {
        // Test code
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        System.out.println(solution(edges));
        System.out.println(solution2(edges));
        System.out.println();
        
        edges = new int[][]{{1,2}, {5,1}, {1,3}, {1,4}};
        System.out.println(solution(edges));
        System.out.println(solution2(edges));
    }
}
