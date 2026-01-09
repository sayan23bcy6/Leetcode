class Solution {
    public int distributeCandies(int[] candyType) {
        int n=candyType.length;
        Set<Integer> set=new HashSet<>();
        int count=0;
        for(int i=0;i<n;i++)
        {
            set.add(candyType[i]);
        }
        count=set.size();
        if(count<=n/2)
        return count;
        else
        return n/2;
    }
}