class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); i++) {
            char letter = sb.charAt(i);
            if (Character.isDigit(letter)) {
                int j = i - 1;
                while (j >= 0 && !Character.isLetter(sb.charAt(j))) {
                    j--;
                }
                if (j >= 0) {
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(j);
                }
                i=-1;
            }
        }

        return sb.toString();
    }
}
