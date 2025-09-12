class Solution {
    Map<Integer, Map<Integer, Boolean>> memo = new HashMap<>();

    public boolean canCross(int[] stones) {
        int n = stones.length;
        if (stones[1] != 1) return false;
        return dp(stones, 1, 1, n);
    }

    boolean dp(int[] stones, int jump, int pos, int n) {
        if (pos == n - 1) return true;

        if (memo.containsKey(pos) && memo.get(pos).containsKey(jump)) {
            return memo.get(pos).get(jump);
        }

        int[] jumps = {jump - 1, jump, jump + 1};
        for (int nextJump : jumps) {
            if (nextJump == 0) continue;

            int nextPos = binarySearch(stones, stones[pos] + nextJump, pos + 1, n - 1);
            if (nextPos != -1 && dp(stones, nextJump, nextPos, n)) {
                memo.computeIfAbsent(pos, k -> new HashMap<>()).put(jump, true);
                return true;
            }
        }

        memo.computeIfAbsent(pos, k -> new HashMap<>()).put(jump, false);
        return false;
    }

    int binarySearch(int[] arr, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; 
            } else if (arr[mid] < target) {
                low = mid + 1; 
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
