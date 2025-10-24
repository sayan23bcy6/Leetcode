class Solution {
    public int nextBeautifulNumber(int n) {
        for (int i = n + 1;; i++) {
            int freq[]=new int[10];
            int num = i;
            while (num > 0) {
                int digit = num % 10;
                freq[digit]++;
                num /= 10;
            }
            boolean ok = true;
            for (int j=0;j<10;j++) {
                if(freq[j]==0)
                continue;
                if (j !=freq[j]) {
                    ok = false;
                    break;
                }
            }
            if (ok) return i;
        }
    }
}