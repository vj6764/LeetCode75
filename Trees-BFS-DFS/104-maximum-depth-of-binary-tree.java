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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int maxDepth = 0;
        Stack<TreeDepthPair> stackPair = new Stack<>();
        stackPair.push(new TreeDepthPair(root, 1));

        while(!stackPair.isEmpty()) {
            TreeDepthPair pair = stackPair.pop();
            TreeNode curNode = pair.node;
            int curDepth = pair.depth;
            
            if(curNode!=null){
                maxDepth = Math.max(maxDepth, curDepth);
                if(curNode.left != null){
                    stackPair.push(new TreeDepthPair(curNode.left, curDepth+1));
                }
                if(curNode.right != null){
                    stackPair.push(new TreeDepthPair(curNode.right, curDepth+1));
                }
            }
        }
        return maxDepth;
    }

    private class TreeDepthPair{
        TreeNode node;
        int depth;

        TreeDepthPair(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
}
