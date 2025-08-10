class Solution {
    private int[] countDigits(int num) {
        int[] freq = new int[10];
        while (num > 0) {
            freq[num % 10]++;
            num /= 10;
        }
        return freq;
    }
    public boolean reorderedPowerOf2(int n) {
        int[] nFreq = countDigits(n);
        
        for (int i = 0; i < 30; i++) {
            int powerOf2 = 1 << i;
            
            if (powerOf2 < 0) { 
                break;
            }
            
            int[] p2Freq = countDigits(powerOf2);
            
            if (Arrays.equals(nFreq, p2Freq)) {
                return true;
            }
        }
        
        return false;
    }
}