class Solution {
    Boolean[][] memo;
    List<List<Integer>> graph;

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        memo = new Boolean[numCourses][numCourses];
        graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for (int[] prereq : prerequisites) graph.get(prereq[0]).add(prereq[1]);

        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(dfs(query[0], query[1]));
        }
        return result;
    }

    boolean dfs(int from, int to) {
        if (memo[from][to] != null) return memo[from][to];
        for (int neighbor : graph.get(from)) {
            if (neighbor == to || dfs(neighbor, to)) return memo[from][to] = true;
        }
        return memo[from][to] = false;
    }
}