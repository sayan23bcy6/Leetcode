class Solution {
    public boolean hasSameDigits(String s) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            list.add(s.charAt(i)-'0');
        }
        while(list.size()>2)
        {
            for(int i=0;i<list.size()-1;i++)
            {
                int a=list.get(i);
                int b=list.get(i+1);
                list.remove(i);
                int c=(a+b)%10;
                list.add(i,c);
            }
            list.remove(list.size()-1);
        }
        return list.get(0)==list.get(1);
    }
}