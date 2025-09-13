class Solution {
    public int maxFreqSum(String s) {
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++)
        {
            freq[s.charAt(i)-'a']++;
        }
        int maxV=0;
        int maxC=0;
        for (int i = 0; i < 26; i++) {
        int num = freq[i];
        char ch = (char) ('a' + i);

        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                maxV = Math.max(maxV, num); 
                break;
            default:
                maxC = Math.max(maxC, num); 
    }
}

        return maxV+maxC;
    }
}