class Solution {
    public char findTheDifference(String s, String t) {
        int freq1[]=new int[26];
        int freq2[]=new int[26];
        for(int i=0;i<t.length();i++)
        {
            if(i<s.length())
            {
                freq1[(int)s.charAt(i)-'a']++;
            }
            freq2[(int)t.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++)
        {
            if(freq1[i]!=freq2[i])
            return (char)('a'+i);
        }
        return ' ';
    }
}