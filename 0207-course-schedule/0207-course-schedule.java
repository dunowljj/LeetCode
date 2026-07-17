class Solution {

    List<Integer>[] adj;

    /**
        0 == not visited
        1 == in dfs path
        2 == complete
     */
    int[] state;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] prequisite : prerequisites) {
            int target = prequisite[0];
            int pre = prequisite[1];

            adj[pre].add(target);
        }

        // 0~n-1
        for (int i = 0; i < numCourses; i++) {
            state = new int[numCourses];
            if (state[i] == 0 && hasCycle(i)) return false;
        }

        return true;
    }

    private boolean hasCycle(int now) {
        if (state[now] == 1) {
            return true;
        }

        if (state[now] == 2) {
            return false;
        }

        state[now] = 1;
        
        for (int next : adj[now]) {
            if (hasCycle(next)) return true;
        }

        state[now] = 2;
        return false;
    }
}