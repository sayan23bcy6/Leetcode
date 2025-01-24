class Solution {
    public int partitionString(String s) 
    {int count=0;
    int p=0;
        for(int i=0;i<s.length();i++)
        {
           for(int j=p;j<i;j++)
           {
               if(s.charAt(i)==s.charAt(j))
              {p=i;
                  count++;break;}
           }
        }
return count+1;
    }
}