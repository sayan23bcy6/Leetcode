class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int size = (n + k - 1) / k;
        String[] arr = new String[size];
        int j = 0;

        for (int i = 0; i < n; i += k) {
            if (i + k <= n) {
                arr[j++] = s.substring(i, i + k);
            } else {
                StringBuilder sb = new StringBuilder(s.substring(i));
                while (sb.length() < k) {
                    sb.append(fill);
                }
                arr[j++] = sb.toString();
            }
        }
        return arr;
    }
}
