class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> l1 = new HashSet<>();
        HashSet<Integer> l2 = new HashSet<>();
        int[] arr = new int[A.length];
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[i]) {
                sum++;
            } else {
                if (l2.contains(A[i])) sum++;
                if (l1.contains(B[i])) sum++;
            }
            arr[i] = sum;
            l1.add(A[i]);
            l2.add(B[i]);
        }

        return arr;
    }
}
