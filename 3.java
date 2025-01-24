class Solution {
    public int lengthOfLongestSubstring(String s) {
        String sum="";
        int max=0;
        int arr[]=new int[128];
        int start=0;
        for(int i=0;i<s.length();i++)
        {
            arr[s.charAt(i)]++;
            while(arr[s.charAt(i)]>1)
            {
                arr[s.charAt(start++)]--;
            }
            max=Math.max(max,i-start+1);

        }
        return max;
    }
}