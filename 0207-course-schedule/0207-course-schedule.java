class Solution {

    List<Integer>[] adj;
    int[] indegree;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new ArrayList[numCourses];
        indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] prequisite : prerequisites) {
            int target = prequisite[0];
            int pre = prequisite[1];

            adj[pre].add(target);
            indegree[target]++;
        }


        // topology sort
        int total = numCourses;
        while (total > 0) {
            int leaf = findLeaf();
            
            if (leaf == -1) break;

            indegree[leaf]--;
            total--;
            for (int next : adj[leaf]) {
                indegree[next]--;
            }

        }

        return total == 0;
    }

    // when leaf isn't exist, return -1;
    private int findLeaf() {
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}