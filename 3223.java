class Solution {
    public int minimumLength(String s) {
        int arr[]=new int[26];
        for(int i=0;i<s.length();i++)
        {
            arr[(int)s.charAt(i)-97]++;
        }
        int sum=0;
        for(int i=0;i<26;i++)
        {
           if(arr[i]>=3)
           {
            if(arr[i]%2==0)
            {
                arr[i]=2;
                sum+=arr[i];
                continue;
            }
            else
            {
                arr[i]=1;
                sum+=arr[i];
                continue;
            }
           }
         sum+=arr[i];

        }        
        return sum;
    }
}