class Solution {
    public int maxDifference(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        int mxOdd = 0, minEven = Integer.MAX_VALUE;
        char cur = chars[0];
        int cnt = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == cur) {
                cnt++;
            } else {
                if ((cnt & 1) == 1) {
                    mxOdd = Math.max(mxOdd, cnt);
                } else {
                    minEven = Math.min(minEven, cnt);
                }
                cur = chars[i];
                cnt = 1;
            }
        }
        if ((cnt & 1) == 1) {
            mxOdd = Math.max(mxOdd, cnt);
        } else {
            minEven = Math.min(minEven, cnt);
        }

        return mxOdd - minEven;
    }
}