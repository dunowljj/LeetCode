class Solution {
    List<Integer>[] adjList;

    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) return true;

        int[] indegree = new int[numCourses];
        
        // 인접리스트 초기화
        adjList = new ArrayList[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            int end = prerequisites[i][0];
            int start = prerequisites[i][1];
            
            indegree[end]++; 
            
            
            adjList[start].add(end);
        }
        
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        

        while (!queue.isEmpty()) {
            int start = queue.poll();

            for (Integer next : adjList[start]) {
                indegree[next]--;
                
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] > 0) return false;
        }
        
        return true;
    }
}

/*
!! 0 <= ai, bi < numCourses
numCourses 1~2000
pre.length 0~5000 -> 0 exception
make graph and check cycle

위상정렬
- 단방향 그래프를 일렬로 정렬시키는 것.
- 진입차수가 0인 노드가 먼저 나타나야한다. 같은 노드를 가르키는 것은 가능하지만, 싸이클이 존재하면 위상정렬이 불가능 하다.
- 진입차수0인 노드 탐색을 시작하고, 해당 노드와 간선을 제거 -> 새로운 진입차수0 노드 발견, 탐색 -> 싸이클 발견 시 종료

해당 노드를 가르키는 노드가 없는 경우
*/