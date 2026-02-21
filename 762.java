class Solution {
    public int countPrimeSetBits(int left, int right) {
        int retval=0;
        while(left<=right)
        {
            int count=Integer.bitCount(left);
            retval+=isPrime(count)?1:0;
            left++;
        }
        return retval;}
        boolean isPrime(int n) {
    if (n <= 1) return false; 
    if (n <= 3) return true;
    
    if (n % 2 == 0 || n % 3 == 0) return false;

    for (int i = 5; i * i <= n; i += 6) {
        if (n % i == 0 || n % (i + 2) == 0)
            return false;
    }
    return true;

    }
}