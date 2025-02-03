class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 0) return 0;
        
        int longest = 1;
        int incSeq = 1;
        int decSeq = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                incSeq++;
                decSeq = 1;
            } else if (nums[i] < nums[i - 1]) {
                decSeq++;
                incSeq = 1;
            } else {
                incSeq = 1;
                decSeq = 1;
            }
            longest = Math.max(longest, Math.max(incSeq, decSeq));
        }
        
        return longest;
    }
}
