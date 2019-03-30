/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    int count;
    boolean removed;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        count = 0;
        removed = false;
        helper(head, n);
        if(removed)
            return head;
        else 
            return head.next;
    }
    
    public ListNode helper(ListNode node, int n){
        if(node == null)
            return null;
        ListNode temp = helper(node.next, n);
        count++;
        if(count == n+1){
            node.next = node.next.next;
            removed = true;
        }
        return node;
    }
}