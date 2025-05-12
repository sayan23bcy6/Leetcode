class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10]; // Frequency of digits
        for (int digit : digits) freq[digit]++;

        List<Integer> result = new ArrayList<>();

        
        for (int c = 0; c <= 8; c += 2) { 
            if (freq[c] == 0) continue;
            
            freq[c]--;
            
            for (int a = 1; a <= 9; a++) { 
                if (freq[a] == 0) continue;

                freq[a]--;
                
                for (int b = 0; b <= 9; b++) {
                    if (freq[b] > 0) {
                        result.add(a * 100 + b * 10 + c);
                    }
                }

                freq[a]++;
            }
            freq[c]++;
        }

        return result.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}