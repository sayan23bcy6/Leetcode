class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] res = new int[n];
        
        for (int i = 0; i < n; i++) {
            int target = nums.get(i);
            if (target == 2) {
                res[i] = -1;
            } else {
                for (int b = 1; b < 31; b++) {
                    if (((target >> b) & 1) == 0) {
                        res[i] = target ^ (1 << (b - 1));
                        break;
                    }
                }
            }
        }
        return res;
    }
}