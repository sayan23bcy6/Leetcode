class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> list = new ArrayList<>();
        int[] prev = new int[26];
        boolean first = true;
        for (String word : words) {
            int[] freq = new int[26];
            for (char c : word.toCharArray()) freq[c - 'a']++;
            if (first || !Arrays.equals(freq, prev)) {
                list.add(word);
                prev = freq;
                first = false;
            }
        }
        return list;
    }
}