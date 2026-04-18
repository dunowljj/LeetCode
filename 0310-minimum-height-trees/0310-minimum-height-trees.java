import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return List.of(0);
        if (n == 2) return List.of(0, 1);

        int[] degree = new int[n];

        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);

            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q.offer(i);
            }
        }

        while (n > 2) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int now = q.poll();

                for (int next : adj[now]) {
                    degree[next]--;
                    if (degree[next] == 1) {
                        q.offer(next);
                    }
                }
            }
            
            n -= size;
        }

        return new ArrayList<>(q);
    }
}