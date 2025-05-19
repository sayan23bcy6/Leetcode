class Solution {
    public String triangleType(int[] nums) {
        int n1=nums[0]+nums[1];
        int n2=nums[1]+nums[2];
        int n3=nums[0]+nums[2];
        int sum=nums[0]+nums[1]+nums[2];
        if(n1<=(sum-n1) || n2<=(sum-n2) || n3<=(sum-n3))
        return "none";
        else
        {
            if(nums[0]==nums[1] && nums[1]==nums[2])
            return "equilateral";
            else if(nums[0]==nums[1] || nums[1]==nums[2] || nums[2]==nums[0])
            return "isosceles";
            else
            return "scalene";
        }
    }
}