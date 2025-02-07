class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int prod = nums[i] * nums[j];
                map.put(prod, map.getOrDefault(prod, 0) + 1);
            }
        }
        
        for (int freq : map.values()) {
            if (freq > 1) {
                count += freq * (freq - 1) / 2;
            }
        }
        
        return count * 8;
    }
}