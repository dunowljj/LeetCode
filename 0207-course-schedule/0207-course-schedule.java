class Solution {
    boolean[] visited;
    boolean[] passedBefore;
    List<Integer>[] adj;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) adj[i] = new ArrayList<>();

        for (int[] pre : prerequisites) {
            adj[pre[0]].add(pre[1]);
        }

        passedBefore = new boolean[numCourses];
        visited = new boolean[numCourses];

        boolean hasCycle = false;
        for (int i = 0; i < numCourses; i++) {
            hasCycle |= hasCycle(i);
        }

        return !hasCycle;
    }

    public boolean hasCycle(int now) {    
        if (visited[now]) return true;
        if (passedBefore[now]) return false;
        passedBefore[now] = true;
        visited[now] = true;

        boolean hasCycle = false;
        for (int next : adj[now]) {
            hasCycle |= hasCycle(next);
        }

        visited[now] = false;
        return hasCycle;
    }
}