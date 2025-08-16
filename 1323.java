class Solution {
    public int maximum69Number (int num) {
        int temp_num = num;
        int pos = -1;
        int place = 0;

        while (temp_num > 0) {
            int digit = temp_num % 10;
            if (digit == 6) {
                pos = place;
            }
            temp_num /= 10;
            place++;
        }

        if (pos != -1) {
            return num + (3 * (int)Math.pow(10, pos));
        }
        
        return num;
    }
}