class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int[] arr = new int[nums.length];
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                arr[0] = nums[0] % 5;
                list.add(arr[0] == 0);
            } else {
                arr[i] = (2 * arr[i - 1] + nums[i]) % 5;
                list.add(arr[i] == 0);
            }
        }
        return list;
    }
}
