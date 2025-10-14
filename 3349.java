class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        for(int i=0;i<=nums.size()-2*k;i++)
        {int j=i;
            for(j=i;j<i+k-1;j++)
            {
                if(nums.get(j)>=nums.get(j+1))
                break;
            }
        int l=i+k;
            for(l=i+k;l<i+2*k-1;l++)
            {
                if(nums.get(l)>=nums.get(l+1))
                break;
            }
            if(j==i+k-1 && l==i+2*k-1)
            return true;
        }
        return false;
    }
}