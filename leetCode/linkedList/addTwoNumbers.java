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
        int carry = l1.val+l2.val;
        ListNode res = new ListNode(carry%10);
        ListNode head = res;
        carry /= 10;
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null && l2 != null){
            carry = l1.val+l2.val+carry;
            res.next = new ListNode(carry%10);
            res = res.next;
            carry /= 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            carry = l1.val+carry;
            res.next = new ListNode(carry%10);
            res = res.next;
            carry /= 10;
            l1 = l1.next;
        }
        while(l2 != null){
            carry = l2.val+carry;
            res.next = new ListNode(carry%10);
            res = res.next;
            carry /= 10;
            l2 = l2.next;
        }
        if(carry == 1)
            res.next = new ListNode(carry%10);
        return head;
    }
}