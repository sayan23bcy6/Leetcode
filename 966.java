class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelInsensitive = new HashMap<>();
        
        for (String word : wordlist) {
            String lower = word.toLowerCase();
            caseInsensitive.putIfAbsent(lower, word);
            vowelInsensitive.putIfAbsent(devowel(lower), word);
        }
        
        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exact.contains(q)) {
                res[i] = q;
                continue;
            }
            String lower = q.toLowerCase();
            if (caseInsensitive.containsKey(lower)) {
                res[i] = caseInsensitive.get(lower);
                continue;
            }
            String devoweled = devowel(lower);
            if (vowelInsensitive.containsKey(devoweled)) {
                res[i] = vowelInsensitive.get(devoweled);
                continue;
            }
            res[i] = "";
        }
        return res;
    }
    
    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) sb.append('*');
            else sb.append(c);
        }
        return sb.toString();
    }
}