class Solution {
    public int addDigits(int num) {
        while(num>=10)
        {   int nums=num;
            int sum=0;
            while(nums>0)
            {
                sum+=nums%10;
                nums/=10;
            }
            num=sum;
        }
        return num;
    }
}