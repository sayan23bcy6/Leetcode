class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Boolean> numMap = new HashMap<>();
        for (int num : nums) {
            numMap.put(num, true);
        }

        int longestStreak = 0;

        for (int num : nums) {
            if (numMap.get(num)) {
                int currentNum = num;
                int currentStreak = 1;
                numMap.put(currentNum, false);
                while (numMap.containsKey(currentNum + 1) && numMap.get(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                    numMap.put(currentNum, false);
                }

                currentNum = num;
                while (numMap.containsKey(currentNum - 1) && numMap.get(currentNum - 1)) {
                    currentNum--;
                    currentStreak++;
                    numMap.put(currentNum, false);
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
          }

        return longestStreak;
    }
}