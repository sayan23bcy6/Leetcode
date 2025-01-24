class Solution {
    public int trap(int[] height) {
        int start = 0, end = height.length - 1;
        int start_max = 0, end_max = 0;
        int water = 0;

        while (start < end) {
            if (height[start] <= height[end]) {
                if (height[start] >= start_max) {
                    start_max = height[start];
                } else {
                    water += start_max - height[start];
                }
                start++;
            } else {
                if (height[end] >= end_max) {
                    end_max = height[end];
                } else {
                    water += end_max - height[end];
                }
                end--;
            }
        }
        return water;
    }
}
