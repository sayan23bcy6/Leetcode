class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int end=1;
        long count=0;
        for(int i=0;i<nums.length;)
        {long countin=0;
            for(int j=i;j<end && end<=nums.length;j++)
            {
                if(nums[j]==0)
                {
                    count+=++countin;
                    end++;
                }
                else break;
            }i=end++;
        }
        return count;
    }
}