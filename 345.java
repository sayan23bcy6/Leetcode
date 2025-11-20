class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : "aeiouAEIOU".toCharArray()) set.add(c);
        char[] arr = s.toCharArray();
        int start = 0, end = arr.length - 1;
        while (start < end) {
            while (start < end && !set.contains(arr[start])) start++;
            while (start < end && !set.contains(arr[end])) end--;
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return new String(arr);
    }
}
