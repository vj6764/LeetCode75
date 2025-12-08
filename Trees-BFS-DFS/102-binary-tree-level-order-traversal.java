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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        //store root in queue first
        queue.add(root);

        while(!queue.isEmpty()){
            //as we are adding elements to queue in for loop, take size initially itself
            int queueSize = queue.size();
            //empty list for level wise node values
            List<Integer> levelResult = new ArrayList<>();
            for(int i=0; i<queueSize; i++){
                //pop the first element in queue
                TreeNode node = queue.poll();
                levelResult.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            result.add(levelResult);
        }
        return result;
    }
}
