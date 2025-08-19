public class Solution {
    public int maximumSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int maxEndWithOneDeletion = arr[0];
        int maxEndWithNoDeletion = arr[0];
        int overallMax = arr[0];
        for (int i = 1; i < n; i++) {
            maxEndWithOneDeletion = Math.max(maxEndWithOneDeletion + arr[i], maxEndWithNoDeletion);
            maxEndWithNoDeletion = Math.max(maxEndWithNoDeletion + arr[i], arr[i]);
            overallMax = Math.max(overallMax, Math.max(maxEndWithOneDeletion, maxEndWithNoDeletion));
        }
        return overallMax;
    }
}