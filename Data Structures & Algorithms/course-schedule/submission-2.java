class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for ( int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        // for each --> prerequisites [0,1]
            for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }


        // state tracking --> 0 = not visited, 1 = visiting, 2 = done
        int[] state = new int[numCourses]; 

        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, graph, state)) return false; // cycle found
        }
        
        return true;
    }

    private boolean dfs(int node, List<List<Integer>> graph, int[] state) {

        // cycle found 
        if (state[node] == 1) return true;

        // already processed
        if (state[node] == 2) return false;

        state[node] = 1;

        for (int neighbor : graph.get(node)) {
            if (dfs(neighbor, graph, state)) return true;
        }

        state[node] = 2;
        return false;
    }
}