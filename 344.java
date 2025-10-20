class Solution {
    public void reverseString(char[] s) {
        int end=s.length-1;
        int start=0;
        while(start<end)
        {
            char temp=s[end];
            s[end]=s[start];
            s[start]=temp;
            start++;
            end--;
        }
    }
}