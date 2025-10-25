class Solution {
    public int totalMoney(int n) {
        int d=n/7;
        int rem=n%7;
        int sum=0;
        for(int i=0;i<d;i++)
        {
            sum+=28+7*i;
        }
        if(rem==0)
        return sum;
        else
        {
            for(int i=1;i<=rem;i++)
            {
                sum+=i;
            }
            sum+=rem*d;
            return sum;
        }
    }
}