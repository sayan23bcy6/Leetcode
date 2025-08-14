class Solution {
    public String largestGoodInteger(String num) {
        String result = "";
        for (int i = 0; i <= num.length() - 3; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
                String goodInteger = num.substring(i, i + 3);
                if (result.isEmpty() || goodInteger.compareTo(result) > 0) {
                    result = goodInteger;
                }
            }
        }
        return result;
    }
}