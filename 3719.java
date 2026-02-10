class Solution {
    public int longestBalanced(int[] nums) {
        int ml = 0;
        int n = nums.length;
    for (int i = 0; i < n; i++) {
        Set<Integer> o = new HashSet<>();
        Set<Integer> e = new HashSet<>();
            for (int j = i; j < n; j++) {
                int x = nums[j];
                if ((x & 1 )!= 0) o.add(x);
                else e.add(x);
                if (o.size() == e.size()) ml = Math.max(ml, j - i + 1);
    }
}
return ml;
    }
}