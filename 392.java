class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0;
        int start=0;
        int end=t.length();
        while(start<end && i<s.length())
        {
            if(s.charAt(i)==t.charAt(start))
            {
                i++;
            }start++;
        }
        if(i!=s.length())
        return false;
        else
        return true;
    }
}