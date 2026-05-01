class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        int max=Integer.MIN_VALUE;
        int sum1=0;
        for(int i=0;i<nums.length;i++)
        {
            sum1+=i*nums[i];
        }
        max=Math.max(max,sum1);
        int newsum=sum1;
        int n=nums.length;
        for(int i=1;i<nums.length;i++)
        {
            newsum=newsum+sum-(n)*nums[n-i];
            max=Math.max(max,newsum);
        }
        return max;
    }
}