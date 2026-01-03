class Solution {
    public int repeatedNTimes(int[] nums) {
        int n=nums.length/2;
        int freq[]=new int[10000];
        for(int i=0;i<nums.length;i++)
        {
            freq[nums[i]]++;
        }
        for(int i=0;i<10000;i++)
        {
            if(freq[i]==n)
            return i;
        }
        return 0;
    }
}