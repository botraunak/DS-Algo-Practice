/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode end = null;
    ListNode revStart = null;
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n) return head;
        ListNode node = head;
        int size = 1;
        while(size < m-1){
            node = node.next;
            size++;
        }
        if(m>1){
            ListNode revEnd = node.next;
            ListNode temp;
            helper(node.next, n, size+1);
            node.next = revStart;
            revEnd.next = end;
        } else {
            helper(node, n, size);
            head.next = end;
            head = revStart;
        }
        
        return head;
    }
    
    public ListNode helper(ListNode node, int n, int size){
        if(size < n){
            ListNode temp = helper(node.next, n, size+1);
            temp.next = node;
            return temp.next;
        }
        else{
            revStart = node;
            end = node.next;
            return node;
        }
    }
}