class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return List.of(0);
        
        List<Set<Integer>> adjList = new ArrayList();
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            adjList.add(new HashSet());
        }
        
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        List<Integer> leaves = new ArrayList();
        for (int i = 0; i < adjList.size(); i++) {
            if (adjList.get(i).size() == 1) leaves.add(i);
        }
        
        
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList();
            for (int i : leaves) {
                int near = adjList.get(i).iterator().next();
                adjList.get(near).remove(i);
   
                if (adjList.get(near).size() == 1) newLeaves.add(near);
            }
            leaves = newLeaves;
        }
        
        return leaves;
    }
    

    
   
}
/*
leafNode 제거하면서 루트를 구하기
루트가 3개 이상이면 leafNode가 존재할 수 밖에 없다. 
-> 1개, 혹은 2개가 남을때까지 제거
-> 남은 노드들이 정답
*/