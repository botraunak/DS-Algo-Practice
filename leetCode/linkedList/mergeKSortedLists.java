/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        
        if(size == 0) return null;
        
        int mid = size/2;
        size--;
        while(size>0){
            for(int i=0; i<=mid; i++){
                lists[i] = merge(lists, 2*i, 2*i+1, size+1);
                //print(lists[i]);
            }
            if(mid == 0)
                break;
            size = mid;
            mid = size/2;
        }
        return lists[0];
    }
    
    public ListNode merge(ListNode[] lists, int l1, int l2, int size){
        if(l2 >= size)
            if(l1 >= size)
                return null;
            else
                return lists[l1];
        
        ListNode list1 = lists[l1], list2 = lists[l2];
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode curr = null;
        if(list1.val <= list2.val){
            curr = list1;
            list1 = list1.next;
        } else {
            curr = list2;
            list2 = list2.next;
        }
        lists[l1] = curr;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        
        if(list1 != null) curr.next = list1;
        if(list2 != null) curr.next = list2;
        
        return lists[l1];
    }
    
    public void print(ListNode node){
        while(node != null){
            System.out.print(node.val + ", ");
            node = node.next;
        }
        System.out.println();
    }
}