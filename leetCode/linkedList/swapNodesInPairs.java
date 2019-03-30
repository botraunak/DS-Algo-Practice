/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next==null)
            return head;
        ListNode temp, node, prev = null;
        node = head;
        head = head.next;
        while(node != null && node.next != null){
            if(prev != null)
                prev.next = node.next;
            temp = node.next.next;
            node.next.next = node;
            node.next = temp;
            prev = node;
            node = node.next;
        }
        return head;
    }
}