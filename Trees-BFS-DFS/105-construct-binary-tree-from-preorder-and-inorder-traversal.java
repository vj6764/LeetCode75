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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Create a map to efficiently find the index of any element in inorder list
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }
        // Call recursive helper function to build the tree
        return separateTree(preorder, inOrderMap, 0, 0, inorder.length-1);
    }

    private TreeNode separateTree(int[] preorder, Map<Integer, Integer> inOrderMap, int rootIndex, int left, int right){
        // Base case: if the left index exceeds the right index, subtree is empty
        if(left>right) return null;
        // Create the root node with the current root element
        TreeNode root = new TreeNode(preorder[rootIndex]);
        // Find the index of the root element in inorder list
        int mid = inOrderMap.get(preorder[rootIndex]);
        // Recursively build the left subtree
        if(mid > left){
            root.left = separateTree(preorder, inOrderMap, rootIndex+1, left,  mid-1);
        }
        // Recursively build the right subtree
        if(mid < right){
            root.right = separateTree(preorder, inOrderMap, rootIndex+mid-left+1, mid+1, right);
        }

        return root;
    }
}
