class Solution {
    public int bitwiseComplement(int n) {
        return ~n & ((1 << Integer.toBinaryString(n).length()) - 1);
    }
}