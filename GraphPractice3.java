// 예시 입력)
// 그래프: {{1, 3}, {0, 2}, {1, 3}, {0, 2}}
// 출력: true

// 그래프: {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}
// 출력: false

// 각 노드에 1또는 -1을 부여한다.
// 각 노드의 인접한 노드에 반대 부호를 붙여주며 움직일 때 부호가 이미 부여되어있는데 같은 부호이면 false를 출력

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class GraphPractice3 {
    public static void solution(int[][] graph) {
        MyGraphList graphList = new MyGraphList();
        int[] vertices = new int[graph.length];


        // 인접 리스트에 각 연결 노드 추가하려 했으나 굳이 리스트를 만들 필요가 X
        // 차례로 각 노드의 인접한 노드에 반대 부호 1 부여, 이미 값이 있는데 반대 부호가 아니라면 false 출력
        // 재귀 함수로도 구현 가능

        for (int i = 0; i < graph.length; i++) {
            if (vertices[i] == 0){
                vertices[i] = 1;
            }
            for (int j = 0; j < graph[i].length; j++) {
                int cur = graph[i][j];
                if (vertices[cur] == 0){
                    vertices[cur] = - vertices[i];
                } else if(vertices[cur] != -vertices[i]) {
                    System.out.println("false");
                    return;
                }
            }
        }
        System.out.println("true");
    }

    public static void main(String[] args) {
        // Test code
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        solution(graph);

        graph = new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        solution(graph);
    }
}
