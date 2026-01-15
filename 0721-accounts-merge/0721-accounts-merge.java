import java.util.*;

class Solution {

    // <name, graph(email <-> email)>
    Map<String, Map<String, Set<String>>> nameGraph = new HashMap<>(); 

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
    
        for (List<String> account : accounts) {
            String name = account.get(0);

            Map<String,Set<String>> adjGraph = nameGraph.getOrDefault(name, new HashMap<>());

            for (int i = 1; i < account.size(); i++) {
                String email1 = account.get(i);
                Set<String> adjEmails = adjGraph.getOrDefault(email1, new HashSet<>());

                for (int j = 1; j < account.size(); j++) {
                    if (i == j) continue;
                    String email2 = account.get(j);
                    adjEmails.add(email2);
                }

                adjGraph.put(email1, adjEmails);
            }

            nameGraph.put(name, adjGraph);
        }

        List<List<String>> answer = new ArrayList<>();

        for (String name : nameGraph.keySet()) {
            Set<String> visit = new HashSet<>();
            Map<String, Set<String>> adjGraph = nameGraph.get(name);

            for (String startEmail : adjGraph.keySet()) {
                if (visit.contains(startEmail)) continue;
                visit.add(startEmail);

                List<String> account = new ArrayList<>();
                account.add(startEmail);
                
                find(adjGraph, startEmail, visit, account);
                
                Collections.sort(account);
                account.add(0, name);
                answer.add(account);
            }
        }

        return answer;
    }

    public void find(Map<String, Set<String>> adjGraph, String start, Set<String> visit, List<String> account) {
        for (String adjEmail : adjGraph.get(start)) {
            if (visit.contains(adjEmail)) continue;
            visit.add(adjEmail);

            account.add(adjEmail);
            find(adjGraph, adjEmail, visit, account);
        }
    }
}
/**
단순히 순차 비교를 하면, 다른 계정 목록을 통해서 통합되어야 할 계정들이 스킵될 가능성이 있다.

String
 */