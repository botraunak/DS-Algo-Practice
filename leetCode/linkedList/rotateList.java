/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {    
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        int size = 0;
        ListNode node = head;
        while(node!=null){
            node = node.next;
            size++;
        }
        k = k%size;
        if(k==0)
            return head;
        
        ListNode temp;        
        k = size-k-1;
        node = head;
        while(k > 0){
            node = node.next;
            k--;
        }
        temp = node.next;
        node.next = null;
        node = temp;
        while(node.next != null){
            node = node.next;
        }
        node.next = head;
        
        return temp;
    }
}