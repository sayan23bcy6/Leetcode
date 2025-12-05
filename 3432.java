class Solution {
    public int countPartitions(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        int suml=0;
        int even=0;
        for(int i=0;i<nums.length-1;i++)
        {
            if(((2*suml-sum) & 1)==0)
            even++;
        }
        return even;
    }
}