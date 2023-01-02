// Practice3
// 주어진 BST 에서 두 노드의 합이 target 값이 되는 경우가 있는지 확인하세요.
// 있으면 true, 없으면 false 반환

// 입력 트리: 5, 3, 6, 2, 4, null, 7
// 결과: true

// 입력 트리: 5,3,6,2,4,null,7
// 결과: false

import java.util.ArrayList;

public class Practice3 {
    public static void solution(Integer[] data, int target) {
        BinarySearchTree bst = new BinarySearchTree();
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null){
                continue;
            }
            bst.addNode(data[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(inOrder(list, bst.head, target));
    }

    public static Boolean inOrder(ArrayList<Integer> list, Node node,int target){
        if (node == null){
            return false;
        }
        if (list.contains(target - node.key)){
            return true;
        }

        if (inOrder(list, node.left, target)){
            return true;
        }

        list.add(node.key);

        if(inOrder(list, node.right, target)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] data = {5, 3, 6, 2, 4, null, 7};
        int target = 9;
        solution(data, target);

        data = new Integer[]{5,3,6,2,4,null,7};
        target = 28;
        solution(data, target);
    }
}
