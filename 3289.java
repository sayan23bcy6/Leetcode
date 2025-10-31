class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int arr[]=new int[2];
        int k=0;
        for(int i=0;i<nums.length;i++)
        {
            if(set.contains(nums[i]))
            arr[k++]=nums[i];
            else
            set.add(nums[i]);
        }
        return arr;
    }
}