class Solution {
    public int kthFactor(int n, int k) {
        int j=0;
        for(int i=1;i<=n;i++)
        {
            if(n%i==0)
           {if(j==(k-1))
           return i;
           j++;}
        }
       if(j<k)
       return -1;
       return 0;
    }
}