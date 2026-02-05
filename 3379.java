class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int[] result=new int[n];
        for(int i=0;i<n;i++)
        {
            int num=nums[i];
            if(num==0)
            {
                result[i]=num;
            }
            else
            {
                result[i]=nums[Math.floorMod(i + num, n)];;
            }
        }
        return result;
    }
}