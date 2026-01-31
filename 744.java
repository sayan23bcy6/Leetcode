class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        return letters[search(letters, target, 0, letters.length - 1)];
    }

    int search(char[] letters, char target, int left, int right) {
        if (left > right) {
            return left % letters.length;
        }

        int mid = left + (right - left) / 2;

        if (letters[mid] > target) {
            return search(letters, target, left, mid - 1);
        } else {
            return search(letters, target, mid + 1, right);
        }
    }
}
