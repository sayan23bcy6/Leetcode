class Solution {
    public int maximumSum(int[] nums) {
        int[] map = new int[82];
        Arrays.fill(map, -1);

        int maxSum = -1;
        for (int num : nums) {
            int digitSum = sumDigits(num);
            if (map[digitSum] != -1) {
                maxSum = Math.max(maxSum, num + map[digitSum]);
            }
            map[digitSum] = Math.max(map[digitSum], num);
        }

        return maxSum;
    }

    private int sumDigits(int num) {
        if(num==0)
        return 0;
        return num%10+sumDigits(num/10);
    }
}
