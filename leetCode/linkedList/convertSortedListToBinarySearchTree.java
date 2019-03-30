/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        return listToBST(list, 0, list.size()-1);
    }
    
    public TreeNode listToBST(List<Integer> list, int low, int high){        
        if(low>high) return null;
        if(low == high) return new TreeNode(list.get(low));
        
        int mid = (low+high)/2;
        
        TreeNode node = new TreeNode(list.get(mid));
        node.left = listToBST(list, low, mid-1);
        node.right = listToBST(list, mid+1, high);
        
        return node;
    }
}