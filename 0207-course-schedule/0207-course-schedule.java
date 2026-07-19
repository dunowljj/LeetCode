import java.util.*;

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
        Queue<Integer> leaves = new LinkedList<>();

        while (total > 0) {

            for (int i = 0; i < indegree.length; i++) {
                if (indegree[i] == 0) {
                    leaves.offer(i);
                    indegree[i] = -1;
                    total--;
                }
            }

            if (leaves.isEmpty()) break;

            while (!leaves.isEmpty()) {
                int leaf = leaves.poll();

                for (int next : adj[leaf]) {
                    indegree[next]--;
                }
            }
        }

        return total == 0;
    }
}