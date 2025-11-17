class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int curr=0;
        int prev=-1*k-1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==1)
            {   curr=i;
                if(curr-prev-1<k)
                return false;
                prev=i;
            }
        }
        return true;
    }
}