class Solution {
    public int minimumDeletions(String s) {
        int deletions = 0;
        int countB = 0;  

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                countB++;
            } else {
                deletions = Math.min(deletions + 1, countB);
            }
        }

        return deletions;
    }
}
