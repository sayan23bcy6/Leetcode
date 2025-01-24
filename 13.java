class Solution {
    public int romanToInt(String s)
     {
    int i=0,sum=0,count=0;
    ArrayList<Integer> arr= new ArrayList<>();
         s=s.trim();
    for(i=0;i<s.length();i++)
    {if(s.charAt(i)=='I')
    {count++;
    arr.add(1);}
    if(s.charAt(i)=='X')
    {arr.add(10);count++;}
    if(s.charAt(i)=='V')
    {arr.add(5);count++;}
    if(s.charAt(i)=='L')
    {arr.add(50);count++;}
    if(s.charAt(i)=='C')
    {arr.add(100);count++;}
    if(s.charAt(i)=='D')
    {arr.add(500);count++;}
    if(s.charAt(i)=='M')
    {arr.add(1000);count++;}
    }  
    for(i=0;i<count;i++)
    {sum=sum+arr.get(i);}  
 for(i=0;i<count;i++)
 {if(i!=count-1)
 {
     if(arr.get(i)<arr.get(i+1))
     {
         sum=sum-2*arr.get(i);
     }
 }}
 return sum;       
    }
}