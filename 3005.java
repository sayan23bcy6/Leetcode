class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] frequency=new int[100];
        Arrays.fill(frequency,0);
        int max=0;
        for(int i=0;i<nums.length;i++)
        {
            frequency[nums[i]-1]++;
            max=Math.max(max,frequency[nums[i]-1]);
        }
        int count=0;
        for(int i=1;i<=100;i++)
        {
            if(frequency[i-1]==0)
            continue;
            if(frequency[i-1]==max)
            count+=max;
        }
        return count;
    }
}