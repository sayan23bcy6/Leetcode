class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n=nums.length;
        backtrack(nums, new ArrayList<>(), result,n);
        return result;
    }
    private void backtrack(int[] nums, List<Integer> path, List<List<Integer>> result,int n) {
        if (path.size() == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int num : nums) {
            if (path.contains(num)) continue;
            path.add(num);
            backtrack(nums, path, result,n);
            path.remove(path.size() - 1);
        }
    }
}