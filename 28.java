class Solution {
    public int strStr(String haystack, String needle) {
      int d=0,i=0;
      if(haystack.length()==1&&needle.length()==1)
      {
          if(haystack.charAt(0)==needle.charAt(0))
          return 0;
      }
      else
      {
       for( i=0;i<=haystack.length()-needle.length();i++)
       {d=i;
           for(int j=0;j<needle.length();j++)
           {
               if(needle.charAt(j)==haystack.charAt(d))
               {
                   d++;
            } }
               if((d-i)==needle.length())
               break;
           
       }}
       if((d-i)==needle.length())
       return i;
       else
       return -1;
    
    }
}