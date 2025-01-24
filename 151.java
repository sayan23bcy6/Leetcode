class Solution 
{
    public String reverseWords(String s) 
    {int i=0,a=0;
    String w="";
    String d="";
        s=s.trim();
        s=" "+s;
        for(i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)!=' ')
            {a=0;
                w=s.charAt(i)+w;
            }
            else
            {if(a<1)
                d=d+" "+w;
                w="";
                a++;
                }
        }
        d=d.trim();
        return d;
        
    }
}