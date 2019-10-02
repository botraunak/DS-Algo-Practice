/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    int[] ans;
    
    public int[] nextLargerNodes(ListNode head) {
        helper(head, 0, new Stack<Integer>());
        return ans;
    }
    
    public void helper(ListNode node, int index, Stack<Integer> stack){
        if(node == null){
            ans = new int[index];
            return;
        }
        helper(node.next, index+1, stack);
        
        while(!stack.empty() && stack.peek()<=node.val)
            stack.pop();
        
        ans[index] = stack.empty()?0:stack.peek();
        stack.push(node.val);
    }
}