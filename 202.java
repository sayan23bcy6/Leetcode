class Solution {
    public int hap(int n)
    {int sum=0;
        while(n!=0)
        {
            sum+=Math.pow(n%10,2);
            n/=10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
       HashSet<Integer> set=new HashSet<>();
        while(!set.contains(n))
        {
            set.add(n);
            n=hap(n);
            if(n==1)
            return true;
        }
        return false;
    }
}