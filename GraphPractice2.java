// 입력 예시)
// 노드 개수 = 3
// 간선 정보  = {{0, 1}, {1, 2}, {2, 0}}
// 출발 노드 = 0
// 종착 노드 = 2
// 출력 : true

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int id;
    Node next;

    public Node(int id, Node next) {
        this.id = id;
        this.next = next;
    }
}

class MyGraphList {
    int vertices[];
    Node[] adjList;
    int elemCnt;

    public MyGraphList() {}
    public MyGraphList(int size) {
        this.vertices = new int[size];
        this.adjList = new Node[size];
        this.elemCnt = 0;
    }

    public boolean isFull() {
        return this.elemCnt == this.vertices.length;
    }

    public void addVertex(int data) {
        if (isFull()) {
            System.out.println("Graph is full!");
            return;
        }

        this.vertices[elemCnt++] = data;
    }

    public void addEdge(int x, int y) {
        this.adjList[x] = new Node(y, this.adjList[x]);
        this.adjList[y] = new Node(x, this.adjList[y]);
    }
}
// 인접 리스트에 엣지 값 추가
// 출발노드의 인접 노드 값들을 큐에 담고 큐에 담긴 노드값들도 하나씩 제거하며 인접 노드를 확인 하며
// 종착 노드가 포함되는지 확인
// 비슷하지만 DFS로 출발지를 출발 노드로 설정해서 리스트에 종착 노드가 있는지 확인하는 방법도 있다.


public class GraphPractice2 {
    public static void solution(int n, int[][] edges, int source, int dest) {
        MyGraphList graph = new MyGraphList(n);
        Queue<Integer> queue = new LinkedList();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < edges.length; i++) {
            graph.addEdge(edges[i][0], edges[i][1]);
        }

        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int curId = queue.poll();
            Node cur = graph.adjList[curId];
            while (cur != null) {
                if (cur.id == dest) {
                    System.out.println("true");
                    return;
                }
                if (visited[cur.id] == false) {
                    queue.add(cur.id);
                    visited[cur.id] = true;
                }
                cur = cur.next;
            }
        }
        System.out.println("false");
    }

    public static void main(String[] args) {
        // Test code
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        int source = 0;
        int dest = 2;
        solution(n, edges, source, dest);

        n = 6;
        edges = new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        source = 0;
        dest = 5;
        solution(n, edges, source, dest);
    }
}
