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
    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }
    
    public boolean isBST(TreeNode root, TreeNode minRef, TreeNode maxRef){
        if(root == null) return true;
        else if(minRef!=null && minRef.val >= root.val) return false;
        else if(maxRef!=null && maxRef.val <= root.val) return false;
        else return isBST(root.left, minRef, root) && isBST(root.right, root, maxRef);
    }
}