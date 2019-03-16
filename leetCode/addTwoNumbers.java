/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode root1 = l1;
        ListNode root2 = l2;
        
        ListNode result = null;
        ListNode itr = null;
        int carry = 0;
        while(root1 != null || root2 != null) {
            int x = (root1 != null) ? root1.val : 0;
            int y = (root2 != null) ? root2.val : 0;
            
            int sum = (x + y + carry);
            carry = sum/10;
            sum = sum%10;
            if (result == null) {
                result = new ListNode(sum);
                itr = result;
            } else {
                itr.next = new ListNode(sum);
                itr = itr.next;
            }
            if (root1 != null) root1 = root1.next;
            if (root2 != null) root2 = root2.next;
        }
        
        if (carry != 0) {
            itr.next = new ListNode(carry);
            itr = itr.next;
        }
        
        return result;
    }
}