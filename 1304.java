class Solution {
    public int[] sumZero(int n) {
        int arr[]=new int[n];
        if(n==1)
        return new int[]{0};
        if((n & 1)==0)
        {
            int k=1;
            for(int i=0;i<n;i++)
            {
                if((i & 1)==0)
                {
                    arr[i]=k;
                }
                else
                {
                    arr[i]=-k;
                    k++;
                }
            }
        }
        else
        {
            int k=1;
            arr[0]=0;
            for(int i=1;i<n;i++)
            {
                if((i & 1)==1)
                {
                    arr[i]=k;
                }
                else
                {
                    arr[i]=-k;
                    k++;
                }
            }
        }
        return arr;
    }
}