import java.util.*;

class Solution {

    Map<String, String> parents = new HashMap<>(); // email -> email
    Map<String, String> names = new HashMap<>();
    Map<String, Integer> sizes = new HashMap<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
       
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);

                names.put(email, name);
                if (!parents.containsKey(email)) {
                    parents.put(email, email);
                    sizes.put(email, 1);
                }
            }

            for (int i = 1; i < account.size() - 1; i++) {
                union(account.get(i), account.get(i + 1));
            }
        }

        Map<String, List<String>> rootToOthers = new HashMap<>(); // name -> List<email>
        for (String key : parents.keySet()) {
            String rootEmail = find(key);
            
            rootToOthers
                .computeIfAbsent(rootEmail, k -> new ArrayList<>())
                .add(key);
        }

        List<List<String>> answer = new ArrayList<>();
        for (String rootEmail : rootToOthers.keySet()) {
            List<String> emails = rootToOthers.get(rootEmail);
            Collections.sort(emails);
            
            String name = names.get(rootEmail);
            emails.add(0, name);
            answer.add(emails);
        }
        
        return answer;
    }

    private void union(String e1, String e2) {
        String p1 = find(e1);
        String p2 = find(e2);

        if (!p1.equals(p2)) {
            int s1 = sizes.get(p1);
            int s2 = sizes.get(p2);

            if (s1 >= s2) {
                parents.put(p2, p1);
                sizes.put(p1, s1 + s2);
            } else {
                parents.put(p1, p2);
                sizes.put(p2, s1 + s2);
            }   
        }
    }

    private String find(String e) {
        if (!parents.get(e).equals(e)) {
            String parent = find(parents.get(e));
            parents.put(e, parent);
            
            return parent;
        }
        else return e;
    }
}