class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int min=nums[0];
        int count=1;
        for(int i=0;i<n;i++)
        {
            if((nums[i]-min)>k)
            {
                count++;
                min=nums[i];
            }
        }
        return count;
    }
}