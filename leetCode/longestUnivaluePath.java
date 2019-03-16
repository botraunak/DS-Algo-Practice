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
    int ans;
    
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        traverse(root);
        return ans;
    }
    
    public int traverse(TreeNode node){
        if(node == null) return 0;
        if(node.left == null && node.right == null)
            return 0;
        int left = traverse(node.left);
        int right = traverse(node.right);
        int left_l = 0, right_l = 0;
        
        if(node.left != null && node.left.val == node.val)
            left_l = left +1;
        
        if(node.right != null && node.right.val == node.val)
            right_l = right +1;
        
        ans = Math.max(ans, left_l + right_l);
        
        return Math.max(left_l, right_l);
    }
}