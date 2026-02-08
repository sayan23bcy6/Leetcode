class Solution {
    public boolean isBalanced(TreeNode root) {
        int arr[] = dfs(root);
        int a = arr[1];
        return a == 1 ? true : false;
    }

    int[] dfs(TreeNode root)
    {  
        if (root == null)
        {
            return new int[]{0, 1};
        }

        int left[] = dfs(root.left);
        int left0 = left[0];
        int left1 = left[1];

        int right[] = dfs(root.right);
        int right0 = right[0];
        int right1 = right[1];

        int diff = Math.abs(left0 - right0);

        if (left1 == 0 || right1 == 0 || diff > 1)
        {
            return new int[]{Math.max(left0, right0) + 1, 0};
        }

        return new int[]{Math.max(left0, right0) + 1, 1};
    }
}
