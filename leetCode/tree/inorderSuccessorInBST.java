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
    boolean found;
    TreeNode temp;
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        found = false;
        temp = null;
        helper(root, p.val);
        return temp;
    }
    
    public void helper(TreeNode node, int val){
        if(node.left != null)
            helper(node.left, val);
        if(temp != null) return;
        if(node.val == val){
            found = true;
            if(node.right != null) helper(node.right, val);
            return;
        }
        if(found){
            temp = node;
            return;
        }
        if(node.right != null)
            helper(node.right, val);
        return;
    }
}