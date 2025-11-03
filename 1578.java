class Solution {
    public int minCost(String colors, int[] neededTime) {
        int sum = 0;
        int maxTime = neededTime[0];
        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                sum += Math.min(maxTime, neededTime[i]);
                maxTime = Math.max(maxTime, neededTime[i]);
            } else {
                maxTime = neededTime[i];
            }
        }
        return sum;
    }
}