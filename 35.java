class Solution {
    public int searchInsert(int[] nums, int target) {
         return insert(nums,target,0,nums.length-1);
    }
    public int insert(int[] nums,int target,int start,int end)
    {
       if (start > end) {
            return start;
        }
        
        int mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return insert(nums, target, mid + 1, end);
        } else {
            return insert(nums, target, start, mid - 1);
        }
    }
}