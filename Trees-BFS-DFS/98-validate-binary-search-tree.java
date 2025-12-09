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
    public boolean isValidBST(TreeNode root) {
        List<Integer> travList = new ArrayList<>();
        //call the inOrderTraversal func
        inOrderTraversal(root, travList);

        boolean isBst = true;
        int prev = travList.get(0);

        for(int i=1; i< travList.size(); i++){
            if(prev >= travList.get(i)){
                isBst = false;
            } 
            prev = travList.get(i);
        }
        return isBst;
    }

    private void inOrderTraversal(TreeNode node, List<Integer> list){
        if(node == null) return;

        inOrderTraversal(node.left, list);
        list.add(node.val);
        inOrderTraversal(node.right, list);
    }
}
