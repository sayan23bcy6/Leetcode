class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] freq = new int[value];
        for (int num : nums) {
            int x = ((num % value) + value) % value;
            freq[x]++;
        }
        int j = 0;
        while (true) {
            int x = j % value;
            if (freq[x] == 0) return j;
            freq[x]--;
            j++;
        }
    }
}