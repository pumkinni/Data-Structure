// 각 입력을 해쉬멥<String, ArrayList>에 key는 이름, value에는 이메일을 입력
// 이미 해쉬맵에 같은 이름이 있다면 이메일 비교하여 같은 이메일이 있는지 확인
// 없으면 다른 키에 저장, 있으면 기존 해쉬맵의 리스트에 저장

// 아니면 리스트로 구성?

// node를 만들어 이름과 이메일리스트를 삽입하여 위의 방법 반복

import java.util.*;

class Node {
    String name;
    ArrayList<String> emails;
    Node(String name, ArrayList emails){
        this.name = name;
        this.emails = emails;
    }
}

public class NLPractice3 {
    public static ArrayList<ArrayList<String>> solution(ArrayList<ArrayList<String>> accounts) {
        ArrayList<Node> list = new ArrayList<>();
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (ArrayList<String> account : accounts){
            String name = account.remove(0);

            // 리스트 이름에 이미 있다면 공통되는 이메일이 있는지 확인
            int sameIdx = checkSameName(name, list); // 공통되는 이메일 인덱스

            // 리스트에 이름이 있거나 중복되는 이메일이 있다면 이메일 추가
            if (sameIdx != -1){
                // 공통되는 이메일 확인 메소드 : 중복되지 않는 이메일 기존 이메일에 추가한 값 반환
                ArrayList<String> newEmail = checkSameEmail(account, list.get(sameIdx).emails);
                if (newEmail.size() == (account.size() + list.get(sameIdx).emails.size())) { // 중복되는 이메일이 없다면
                    list.add(new Node(name, account));
                } else{
                    list.get(sameIdx).emails = newEmail;
                }
            } else { // 리스트 이름에 아직 없거나 중복되는 이메일이 없다면
                list.add(new Node(name, account));
            }
        }

        for (Node account : list){

            account.emails.add(0, account.name);
            result.add(account.emails);
        }

        return result;
    }

    public static int checkSameName(String name, ArrayList<Node> list){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).name == name){
                return i;
            }
        }
        return -1;
    }

    public static ArrayList<String> checkSameEmail(ArrayList<String> account, ArrayList<String> emails){
        ArrayList<String> newEmails = (ArrayList<String>)emails.clone();

        for (String email : account){
            if (!emails.contains(email)){
                newEmails.add(email);
            }
        }
        return newEmails;

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
