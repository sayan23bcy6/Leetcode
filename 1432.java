class Solution {
    public int maxDiff(int num) {
        String str = intToString(num);
        String s = str;
        int i;
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '9') break;
        }
        if (i != str.length()) {
            char target = str.charAt(i);
            str = str.replace(target, '9');
        }
        int max = stringToInt(str);
        if (s.charAt(0) != '1') {
            char target = s.charAt(0);
            s = s.replace(target, '1');
        } else {
            for (i = 1; i < s.length(); i++) {
                if (s.charAt(i) != '0' && s.charAt(i) != '1') break;
            }
            if (i != s.length()) {
                char target = s.charAt(i);
                s = s.replace(target, '0');
            }
        }
        int min = stringToInt(s);

        return max - min;
    }

    public static String intToString(int num) {
        return Integer.toString(num);
    }

    public static int stringToInt(String str) {
        return Integer.parseInt(str);
    }
}
