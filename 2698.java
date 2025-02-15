class Solution {
    public int punishmentNumber(int n) {
        int punishmentNumber = 0;
        for (int i = 1; i <= n; i++) {
            if (isPunishmentNumber(i)) {
                punishmentNumber += i * i;
            }
        }
        return punishmentNumber;
    }

    private boolean isPunishmentNumber(int i) {
        int square = i * i;
        String squareStr = Integer.toString(square);
        return canPartition(squareStr, 0, i);
    }

    private boolean canPartition(String str, int index, int target) {
        if (index == str.length()) {
            return target == 0;
        }

        for (int j = index + 1; j <= str.length(); j++) {
            int num = Integer.parseInt(str.substring(index, j));
            if (canPartition(str, j, target - num)) {
                return true;
            }
        }

        return false;
    }
}
