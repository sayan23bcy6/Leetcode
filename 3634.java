class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int max=0;
        int j=0;
        if(n==1)
        return 0;
        for(int i=0;i<n-1;i++)
        {
            int num=nums[i];
            while(j<n && nums[j]<=(long)k*num)
            {
                j++;
            }
            max=Math.max(max,j-i);
        }
        return n-max;
    }
}