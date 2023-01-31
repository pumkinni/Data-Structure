import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class P3_1 {
    public static ArrayList<ArrayList<String>> solution(ArrayList<ArrayList<String>> accounts) {
        HashMap<String, HashSet<String>> graph = new HashMap<>();
        HashMap<String, String> nodes = new HashMap<>();

        for (ArrayList<String> account : accounts){
            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                nodes.put(account.get(i), name);
                if (!graph.containsKey(account.get(i))){
                    graph.put(account.get(i), new HashSet<>());
                }
                if (i == 1) {
                    continue;
                }

                graph.get(account.get(i)).add(account.get(i - 1));
                graph.get(account.get(i-1)).add(account.get(i));

            }
        }
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        for (String node : nodes.keySet()){
            if (!visited.contains(node)) {
                ArrayList<String> list = new ArrayList<>();
                dfs(list, node, graph, visited);
                list.add(0, nodes.get(node));
                result.add(list);
            }
        }

        return result;
    }

    public static void dfs(ArrayList<String> list, String email, HashMap<String, HashSet<String>> graph, HashSet<String> visited){

        if (visited.contains(email)){
            return;
        }

        visited.add(email);
        list.add(email);

        for (String adjEmail : graph.get(email)){
            if (!visited.contains(adjEmail)){
                dfs(list, adjEmail, graph, visited);
            }
        }


    }

    public static void main(String[] args) {
        // Test code
        ArrayList<ArrayList<String>> accounts = new ArrayList<>();
        accounts.add(new ArrayList<>(Arrays.asList("John", "john@mail.com", "john_lab@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John", "john@mail.com", "john02@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("Mary", "mary@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com")));
        accounts = solution(accounts);
        for (ArrayList<String> item: accounts) {
            System.out.println(item);
        }
    }
}
