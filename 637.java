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
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> avg=new ArrayList<>();
        if(root==null)
        return avg;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            double sum=0;
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node=queue.poll();
                sum+=node.val;  
                if(node.left!=null)
                queue.offer(node.left);
                if(node.right!=null)
                queue.offer(node.right);     
            }
            avg.add(sum/size);
        }
        return avg;
    }
}