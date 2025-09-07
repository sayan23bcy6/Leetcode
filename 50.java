class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        if((n & 1)==0)
        {if(n==0)
        return 1;
            return fastPow(x*x,n/2);
        }
        else
        {   if(n==1)
            return x;
            return x*fastPow(x,n-1);
        }
    }
}
