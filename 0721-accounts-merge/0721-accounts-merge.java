class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> names = new HashMap(); // Map<email,name> : 중복없이 한 종류 씩 있는 email + 해당하는 이름
        Map<String, Set<String>> graphMap = new HashMap(); // Map<email, Set<email>> : email로 해당 email 인접 노드 검색
        // 굳이 Set을 써야하는 이유가 있나?
        
        
        for (List<String> account : accounts) {
            String name = account.get(0);
                
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);    
                
                names.put(email, name);
                
                if (!graphMap.containsKey(email)) {
                    graphMap.put(email, new HashSet());
                }
                
                if (i == 1) continue;
                
                graphMap.get(account.get(i)).add(account.get(i - 1));
                graphMap.get(account.get(i - 1)).add(account.get(i));
            }
        }
        
        List<List<String>> answer = new ArrayList();
        Set<String> visited = new HashSet();
        
        for (String email : names.keySet()) {
            String name = names.get(email);
            
            List<String> ans = new ArrayList();
            
            if (visited.add(email)) {
                dfs(email, graphMap, ans, visited);
                
                Collections.sort(ans);
                ans.add(0, name);
                answer.add(ans);
            }
        }
        
        return answer;
    }
    
    private void dfs(String email, Map<String, Set<String>> graphMap, List<String> ans, Set<String> visited) {
        ans.add(email);
        
        for (String next : graphMap.get(email)) {
            if (visited.add(next)) {
                dfs(next, graphMap, ans, visited);
            }
        }
    }
}

/*
accounts[i] -> [0] name / [1]~[N] emails

email길이가 불규칙하다.

email Node들을 연결시켜서 통합하기!
인접한 email들을 서로 연결하다보면, 자연스럽게 같은 이름에 대해 그래프가 형성된다.
*/
