import java.util.HashMap;

public class P3_Practice5 {
    public static class Node {
        Boolean isTerminal;
        HashMap<Character, Node> child;

        public Node() {
            this.isTerminal = false;
            this.child = new HashMap<>();
        }
    }
    public static class Trie{
        Node root;

        public Trie() {
            this.root = new Node();
        }

        public void insert(String str){
            Node cur = this.root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                cur.child.putIfAbsent(c, new Node());
                cur = cur.child.get(c);

                if (i == str.length() - 1){
                    cur.isTerminal = true;
                }
            }
        }
    }
    public static double solution(String[] words) {
        if (words.length == 0 || words == null){
            return -1;
        }

        double sum = 0;

        Trie trie = new Trie();
        for (String word : words){
            trie.insert(word);
        }

        for (String word : words){
            sum += checkCnt(word, trie);
        }


        return sum / words.length;
    }

    public static int checkCnt(String word, Trie trie){
        Node cur = trie.root;
        int cnt = 1;
        cur = cur.child.get(word.charAt(0));
        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);

            if (cur.child.size() > 1) {
                cnt++;
            }

            cur = cur.child.get(c);

            if (i != word.length() - 1){
                if (cur.isTerminal){
                    cnt ++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        // Test code
        String[] words = {"hell", "hello", "heaven", "java"};
        System.out.printf("%.2f\n", solution(words));   // (2 + 3 + 2 + 1) / 4 = 2.00

        words = new String[] {"abca", "abcb", "abcc"};  // (2 + 2 + 2) / 3 = 2.00
        System.out.printf("%.2f\n", solution(words));

        words = new String[] {"cloud", "cloudy", "rain", "rainy", "sun", "sunny"};
        System.out.printf("%.2f\n", solution(words));   // (1 + 2 + 1 + 2 + 1 + 2) / 6 = 1.50
    }
}
