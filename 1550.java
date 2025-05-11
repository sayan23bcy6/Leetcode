class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for(int i=0;i<arr.length-2;i++)
        {
            if(odd(arr[i]) && odd(arr[i+1]) && odd(arr[i+2]))
            return true;
        }
        return false;
    }
    boolean odd(int num)
    {
        if(num%2==0)
        return false;
        else
        return true;
    }
}