class Solution {
    public boolean rotateString(String s, String goal) {
        int n=s.length();
        s=s+s;
        return n==goal.length() && s.contains(goal);
    }
}