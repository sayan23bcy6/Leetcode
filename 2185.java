class Solution {
    public int prefixCount(String[] words, String pref) {
        int k=0;
        for(int i=0;i<words.length;i++)
        {   if(words[i].length()<pref.length())
            continue;
            if(pref.equals(words[i].substring(0,pref.length())))
            k++;
        }
        return k;
    }
}