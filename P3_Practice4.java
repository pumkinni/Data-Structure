import java.util.HashMap;

class Node {
    HashMap<Character, Node> child;
    boolean isTerminal;

    public Node() {
        this.child = new HashMap<>();
        this.isTerminal = false;
    }
}

class Trie {
    Node root;

    public Trie() {
        this.root = new Node();
    }

    public boolean insert(String str) {
        Node cur = this.root;
        boolean isSame = true;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (cur.child.containsKey(c)){
                cur = cur.child.get(c);
            } else {
                cur.child.put(c, new Node());
                cur = cur.child.get(c);
                isSame = false;
            }

            if (i == str.length() - 1) {
                if (isSame){
                    return false;
                } else {
                    cur.isTerminal = true;
                }
            } else {
                if (isSame && cur.isTerminal){
                    return false;
                }
            }
        }
        return true;
    }

}

public class P3_Practice4 {
    public static boolean solution(String[] nums) {
        Trie trie = new Trie();

        for (String num : nums){
            if (!trie.insert(num)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Test code
        String[] nums = {"911", "123456789", "911234"};
        System.out.println(solution(nums)); // false

        nums = new String[]{"113", "12345", "12344", "98765"};
        System.out.println(solution(nums)); // true

    }
}
