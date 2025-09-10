class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        Map<Integer, Set<Integer>> userLanguages = new HashMap<>();
        for (int i = 0; i < m; i++) {
            Set<Integer> set = new HashSet<>();
            for (int lang : languages[i]) set.add(lang);
            userLanguages.put(i + 1, set);
        }

        Set<Integer> needTeach = new HashSet<>();
        for (int[] friend : friendships) {
            int u = friend[0], v = friend[1];
            Set<Integer> langsU = userLanguages.get(u);
            Set<Integer> langsV = userLanguages.get(v);
            boolean canCommunicate = false;
            for (int lang : langsU) {
                if (langsV.contains(lang)) {
                    canCommunicate = true;
                    break;
                }
            }
            if (!canCommunicate) {
                needTeach.add(u);
                needTeach.add(v);
            }
        }

        if (needTeach.isEmpty()) return 0;

        int[] freq = new int[n + 1];
        for (int user : needTeach) {
            for (int lang : userLanguages.get(user)) {
                freq[lang]++;
            }
        }

        int maxFreq = 0;
        for (int lang = 1; lang <= n; lang++) {
            maxFreq = Math.max(maxFreq, freq[lang]);
        }

        return needTeach.size() - maxFreq;
    }
}
