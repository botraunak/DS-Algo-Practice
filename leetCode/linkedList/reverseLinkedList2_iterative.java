/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) return head;
        int c = 1;
        ListNode node = head;
        ListNode start = null;
        while (c < m) {
            start = node;
            node = node.next;
            c++;
        }
        
        ListNode revHead = node;
        ListNode revLast = node;
        
        while (c < n) {
            node = revHead.next;
            if (start != null)
                start.next = node;
            revHead.next = node.next;
            node.next = revLast;
            revLast = node; 
            if (start == null)
                head = node;
            c++;
        }
    
        
        return head;
    }
}