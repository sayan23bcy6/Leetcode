class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
            sum+=nums[i];
        }
        if(min!=0)
        return 0;
        int num=(max*(max+1))/2;
        if(sum!=num)
        return num-sum;
        return max+1;
    }
}