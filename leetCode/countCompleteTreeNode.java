/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        return count(root);
    }
    
    private int count(TreeNode root){
        if(root == null)
            return 0;
        int c = count(root.left) + count(root.right);
        return c+1;
    }
}