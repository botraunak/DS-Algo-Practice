/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode s = null, g = null, g_start = null, node = head;
        while(node != null){
            if(node.val<x){
                if(s==null){
                    s = node;
                    head = s;
                } else {
                    s.next = node;
                    s = s.next;
                }
            } else {
                if(g==null){
                    g = node;
                    g_start = g;
                } else{
                    g.next = node;
                    g = g.next;
                }
            }
            node = node.next;
        }
        
        if(s != null) s.next = g_start;
        if(g != null) g.next = null;
        
        return head;
    }
}