class Solution {
    public int fib(int n) {
        int arr[]=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            arr[i]=-1;
        }
        return fibo(n,arr);
    }
    int fibo(int n,int[] arr)
    {
        if(n==0)
        return 0;
        if(n==1)
        return 1;
        if(arr[n]!=-1)
        return arr[n];
        arr[n]=fibo(n-1,arr)+fibo(n-2,arr);
        return arr[n];
    }
}