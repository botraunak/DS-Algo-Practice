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
        int curr = 1;
        while(curr < m-1){
            node = node.next;
            curr++;
        }
        if(m>1){
            ListNode revEnd = node.next;
            helper(node.next, n, curr+1);
            node.next = revStart;
            revEnd.next = end;
        } else {
            helper(node, n, curr);
            head.next = end;
            head = revStart;
        }
        
        return head;
    }
    
    public ListNode helper(ListNode node, int n, int curr){
        if(curr < n){
            ListNode temp = helper(node.next, n, curr+1);
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