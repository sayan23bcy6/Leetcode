class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int remainingGas = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            remainingGas += gas[i] - cost[i];

            if (remainingGas < 0) {
                start = i + 1;
                remainingGas = 0;
            }
        }

        return totalGas >= totalCost ? start : -1;
    }
}
