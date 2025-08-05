class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n=fruits.length;
        int j=0;
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                if(fruits[i]<=baskets[j])
                {
                    baskets[j]=0;
                    break;
                }
            }
            if(j==n)
            count++;
        }
        return count;
    }
}