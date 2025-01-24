class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map=new HashMap<>();
        int i=0;
        for(i=0;i<s.length();i++)
        {
            if(map.get(s.charAt(i))!=null)
            {
                if(map.get(s.charAt(i))==t.charAt(i))
                continue;
                else 
                break;
            }
            else if(map.containsValue(t.charAt(i)))
            break;
            else
            {
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        return i==s.length();
    }
}