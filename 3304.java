class Solution {
    public char kthCharacter(int k) {
        StringBuilder word = new StringBuilder("a");
        
        while (word.length() < k) {
            int len = word.length();
            for (int i = 0; i < len && word.length() < k; i++) {
                char c = word.charAt(i);
                char next = (char) ((c == 'z') ? 'a' : c + 1);
                word.append(next);
            }
        }
        
        return word.charAt(k - 1);}
}
