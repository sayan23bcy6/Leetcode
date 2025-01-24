class Solution {
    public String mergeAlternately(String word1, String word2) {
        int max=word1.length();>word2.length();?word1.length();:word2.length();;
        String sum="";
        for(int i=0;i<max;i++)
        {if(i<word1.length();)
            sum+=word1.charAt(i);
        if(i<word2.length())
            sum+=word2.charAt(i);
        }
        return sum;
    }
}