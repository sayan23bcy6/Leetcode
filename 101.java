/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean mirror(TreeNode left,TreeNode right)
    {
        if(left==null && right==null)
        return true;
        if(left==null || right==null)
        return false;
        if (left.val != right.val)
        return false;
        return mirror(left.left, right.right) && mirror(left.right, right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
        return true;
        return mirror(root.left,root.right);
    }
}