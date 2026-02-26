import java.math.BigInteger;
class Solution {
    public int numSteps(String s) {
        BigInteger num = new BigInteger(s, 2);
        int count = 0;

        while (!num.equals(BigInteger.ONE)) {
            if (num.and(BigInteger.ONE).equals(BigInteger.ZERO)) {
                num = num.shiftRight(1);
            } else {
                num = num.add(BigInteger.ONE);a
            }
            count++;
        }

        return count;
    }
}