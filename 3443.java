class Solution {
    public int maxDistance(String s, int k) {
        int n = s.length();
        int N = 0, S = 0, E = 0, W = 0, ans = 0;
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'N') N++;
            if (c == 'S') S++;
            if (c == 'E') E++;
            if (c == 'W') W++;
            
            int dist = Math.abs(N - S) + Math.abs(E - W) + 2 * k;
            ans = Math.max(ans, Math.min(dist, i + 1));
        }
        
        return ans;
    }
}