class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(arr);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++)
        {
            min=Math.min(min,arr[i+1]-arr[i]);
        }
        for(int i=0;i<arr.length-1;i++)
        {
            if((arr[i+1]-arr[i])==min)
            {
                List<Integer> listnew=new ArrayList<>();
                listnew.add(arr[i]);
                listnew.add(arr[i+1]);
                list.add(listnew);
            }
        }
        return list;
    }
}