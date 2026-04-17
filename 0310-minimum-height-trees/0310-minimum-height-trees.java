import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
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

        int count = n;
        Set<Integer> answer = new HashSet<>();
        for (int i = 0; i < n; i++) answer.add(i);

        while (count > 2) {
            List<Integer> removeCand = new ArrayList<>();
            for (int node = 0; node < degree.length; node++) {
                if (degree[node] == 1) {
                    removeCand.add(node);
                }
            }

            for (int node : removeCand) {
                int adjNode = adj[node].get(0);
                
                degree[node]--;
                degree[adjNode]--;

                adj[node].remove(0);
                for (int i = 0; i < adj[adjNode].size(); i++) {
                    if (adj[adjNode].get(i) == node) {
                        adj[adjNode].remove(i);
                        break;
                    }
                }

                answer.remove((Integer)node);
                count--;
            }
        }

        // 노드가 한 개만 남았을때는, 차수가 모두 0이 되어버리므로 degree만으로 판단 불
        return new ArrayList<>(answer);
    }
}