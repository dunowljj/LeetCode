class Solution {

    List<Integer>[] adj;
    boolean[] visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new ArrayList[numCourses + 1];

        for (int i = 0; i <= numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] prequisite : prerequisites) {
            int target = prequisite[0];
            int pre = prequisite[1];

            adj[pre].add(target);
        }

        // 0~n-1
        boolean canFinish = false;
        for (int i = 0; i <= numCourses; i++) {
            visited = new boolean[numCourses + 1];
            canFinish |= hasCycle(i);
        }
        return !canFinish;
    }

    private boolean hasCycle(int start) {
        visited[start] = true;

        for (int next : adj[start]) {
            if (visited[next]) return true;
            if (hasCycle(next)) return true;
        }

        return false;
    }
}
