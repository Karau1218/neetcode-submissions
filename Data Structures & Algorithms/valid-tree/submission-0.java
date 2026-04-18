public class Solution {

    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) return false;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        Set<Integer> visited = new HashSet<>();
        if (hasCycle(0, -1, graph, visited)) return false;

      
        return visited.size() == n;
    }

    private boolean hasCycle(int node, int parent,
                             List<List<Integer>> graph,
                             Set<Integer> visited) {

        visited.add(node);

        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) continue; 

            if (visited.contains(neighbor)) return true; 

            if (hasCycle(neighbor, node, graph, visited)) return true;
        }

        return false;
    }
}