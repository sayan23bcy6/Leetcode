class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)
        return nums[0];
        int[] arr=new int[n];
        Arrays.fill(arr,-1);
        return Math.max(dp(nums,arr,n,0),dp(nums,arr,n,1));
    }
    int dp(int[] nums,int[] arr,int n,int i)
    {
        if(i>=n) 
        return 0;
        if(arr[i]!=-1)
        return arr[i];
        if(i==n-1)
        {
        arr[i]=nums[i];
        return arr[i];
        }
        arr[i]=nums[i]+Math.max(dp(nums,arr,n,i+2),dp(nums,arr,n,i+3));
        return arr[i];
    }
}