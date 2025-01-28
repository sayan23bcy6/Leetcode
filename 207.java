import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (isCyclic(graph, i, visited, recStack)) {
                return false;
            }
        }
        return true;
    }

    private boolean isCyclic(List<List<Integer>> graph, int node, boolean[] visited, boolean[] recStack) {
        if (recStack[node]) return true;
        if (visited[node]) return false;

        visited[node] = true;
        recStack[node] = true;
        
        for (Integer neighbor : graph.get(node)) {
            if (isCyclic(graph, neighbor, visited, recStack)) {
                return true;
            }
        }

        recStack[node] = false;
        return false;
    }
}
