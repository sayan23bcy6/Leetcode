class Solution 
{
    public int removeDuplicates(int[] nums) 
    {
        ArrayList<Integer> arr=new ArrayList<>();
        ArrayList<Integer> arrl=new ArrayList<>();
        arr.add(nums[0]);
        int size=1;
        for(int i=0;i<nums.length;i++)
        {if(i!=nums.length-1){
            if(nums[i]!=nums[i+1])
            {
                arr.add(nums[i+1]);
                arrl.add(size);
                size=1;
                if((i+1)==nums.length-1)
                arrl.add(1);
            }
            else
            {
                size++;
            }}
            else
            arrl.add(size);
        }int k=0;int j=0;
        for(int i=0;i<arr.size();i++)
        {
            if(arrl.get(i)>=2)
            {
                nums[j++]=arr.get(i);
                nums[j++]=arr.get(i);k+=2;
            }
            else
            {
                nums[j++]=arr.get(i);k++;
            }
        }
        return k;
    }
}