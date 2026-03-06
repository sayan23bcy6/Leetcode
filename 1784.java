class Solution {
    public boolean checkOnesSegment(String s) {
        char prev = s.charAt(0);
        boolean foundZeroAfterOne = false;

        for(int i = 1; i < s.length(); i++) {
            if(prev == '1' && s.charAt(i) == '0')
                foundZeroAfterOne = true;

            if(foundZeroAfterOne && s.charAt(i) == '1')
                return false;

            prev = s.charAt(i);
        }
        return true;
    }
}