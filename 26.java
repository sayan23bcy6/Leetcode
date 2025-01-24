class Solution {
    public int removeDuplicates(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        int k=0;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]!=nums[i+1])
            {
                arr.add(nums[i+1]);
                k++;
            }
        }int j=1;
        for(int i=0;i<arr.size();i++)
        {
            nums[j]=arr.get(i);
            j++;
        }
        return k+1;
    }
}