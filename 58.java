class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
      int len=s.length();
      String a="";
     int i=0;
     for(i=len-1;i>=0;i--)
     {if(s.charAt(i)==' ')
     break;
         a=s.charAt(i)+a;
     } 
     return a.length();
    }
}