class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        int length = 0;
        boolean usedMiddle = false;

        for (String word : counts.keySet()) {
            String rev = new StringBuilder(word).reverse().toString();

            if (!word.equals(rev)) {
                if (counts.containsKey(rev)) {
                    int pairs = Math.min(counts.get(word), counts.get(rev));
                    length += pairs * 4;
                    counts.put(word, counts.get(word) - pairs);
                    counts.put(rev, counts.get(rev) - pairs);
                }
            } else {
                int count = counts.get(word);
                int pairs = count / 2;
                length += pairs * 4;
                counts.put(word, count - pairs * 2);
            }
        }

        for (String word : counts.keySet()) {
            if (word.charAt(0) == word.charAt(1) && counts.get(word) > 0) {
                length += 2;
                break;
            }
        }

        return length;
    }
}