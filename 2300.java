class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int[] pairs = new int[n];
        Arrays.sort(potions);
        int m = potions.length;

        for (int i = 0; i < n; i++) {
            long minPotion = (long) Math.ceil((double) success / spells[i]);
            int j = binarySearch(potions, 0, m - 1, minPotion);
            pairs[i] = m - j;
        }

        return pairs;
    }

    int binarySearch(int[] potions, int start, int end, long target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (potions[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start;
    }
}
