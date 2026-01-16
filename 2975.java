class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Arrays.sort(hFences);
        Arrays.sort(vFences);

        int a = hFences.length;
        int[] hBar = new int[a + 2];
        hBar[0] = 1;
        hBar[a + 1] = m;
        for (int i = 1; i <= a; i++) hBar[i] = hFences[i - 1];

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < hBar.length; i++)
            for (int j = i + 1; j < hBar.length; j++)
                set.add(hBar[j] - hBar[i]);

        int b = vFences.length;
        int[] vBar = new int[b + 2];
        vBar[0] = 1;
        vBar[b + 1] = n;
        for (int i = 1; i <= b; i++) vBar[i] = vFences[i - 1];

        long max = -1;
        for (int i = 0; i < vBar.length; i++)
            for (int j = i + 1; j < vBar.length; j++) {
                int d = vBar[j] - vBar[i];
                if (set.contains(d)) max = Math.max(max, d);
            }

        if (max == -1) return -1;
        return (int)((max * max) % 1_000_000_007);
    }
}
