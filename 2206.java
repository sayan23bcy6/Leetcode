class Solution {
    public boolean divideArray(int[] nums) {
        if (nums.length % 2 != 0) {
            return false;
        }

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (int count : frequencyMap.values()) {
            if (count % 2 != 0) {
                return false;
            }
        }
        
        return true;
    }
}