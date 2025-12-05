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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;

        //if either one of nodes are null or values are not equal then they are not same
        if(p == null || q == null || (p.val != q.val)) return false;

        boolean leftCompare = isSameTree(p.left, q.left);
        boolean rightCompare = isSameTree(p.right, q.right);

        return leftCompare && rightCompare;
    }
}
