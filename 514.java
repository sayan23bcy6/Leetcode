class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        Map<Character, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = ring.charAt(i);
            if (!pos.containsKey(c)) {
                pos.put(c, new ArrayList<>());
            }
            pos.get(c).add(i);
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        List<Integer> firstCharPositions = pos.get(key.charAt(0));
        for (int j : firstCharPositions) {
            dp[0][j] = Math.min(j, n - j) + 1;
        }
        for (int i = 1; i < m; i++) {
            List<Integer> prevCharPositions = pos.get(key.charAt(i - 1));
            List<Integer> currCharPositions = pos.get(key.charAt(i));
            for (int j : currCharPositions) {
                for (int k : prevCharPositions) {
                    int dist = Math.min(Math.abs(j - k), n - Math.abs(j - k));
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + dist + 1);
                }
            }
        }
        int minSteps = Integer.MAX_VALUE;
        for (int steps : dp[m - 1]) {
            minSteps = Math.min(minSteps, steps);
        }
        return minSteps;
    }
}