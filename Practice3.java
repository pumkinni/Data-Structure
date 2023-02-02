import java.util.*;

public class Practice3 {
    public static ArrayList<ArrayList<String>> solution(ArrayList<ArrayList<String>> accounts) {
        Map<String , ArrayList<ArrayList<String>>> map = new HashMap<>();

        for (ArrayList<String> account : accounts){
            String name = account.remove(0);

            if (map.containsKey(name)){
                boolean isSame = false;

                for (int i = 0; i < map.get(name).size(); i++) {
                    ArrayList<String> email = map.get(name).get(i);

                    for (String e :email){
                        if (account.contains(e)){
                            isSame = true;
                            break;
                        }
                    }
                    if (isSame){
                        for (String em : account){
                            if (!email.contains(em)){
                                map.get(name).get(i).add(em);
                            }
                        }
                        break;
                    }
                }
                if (!isSame){
                    map.get(name).add(account);
                }

            } else {
                map.put(name, new ArrayList());
                map.get(name).add(account);
            }
        }

        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (Map.Entry<String, ArrayList<ArrayList<String>>> accs : map.entrySet()){
            for (ArrayList<String> ac : accs.getValue()) {
                ac.add(0, accs.getKey());
                result.add(ac);
            }
        }

        return result;
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
