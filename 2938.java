class Solution {
    public long minimumSteps(String s) {
        long swap=0;
        int black=0;
        int i=0;
        while(i<s.length())
        {
            if(s.charAt(i)=='0')
            swap+=(long)black;
            else
            black++;
            i++;
        }
        return swap;
    }
}