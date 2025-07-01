class Solution {
    public int possibleStringCount(String word) {
    int freq=0;
    int count=1;
     for(int i=1;i<word.length();i++)
     {
        if(word.charAt(i)==word.charAt(i-1))
        {
            freq++;
        }
        else
        {
            count+=freq;
            freq=0;
        }
     }
     return count+freq;
    }
}