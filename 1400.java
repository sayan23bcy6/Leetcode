class Solution {
    public boolean canConstruct(String s, int k) {
        if(k>s.length())
        return false;
        else
        {int arr[]=new int[26];
        int a=0;
            for(int i=0;i<s.length();i++)
            {
                arr[(int)s.charAt(i)-97]++;
            }
            for(int i=0;i<26;i++)
            {
                if(arr[i]%2!=0)
                a++;
            }
            if(a<=k)
            return true;
            else
            return false;
        }
    }
}