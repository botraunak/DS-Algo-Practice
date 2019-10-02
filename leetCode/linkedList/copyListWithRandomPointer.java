/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        HashMap<Integer, Node> map = new HashMap<>();
        Node headNew = new Node(head.val, null, null);
        Node temp1 = head;
        Node temp2 = headNew;
        map.put(headNew.val, headNew);
        Node node = head.next;
        head = headNew;
        while(node!=null){
            Node n = new Node(node.val, null, null);
            map.put(n.val, n);
            headNew.next = n;
            node = node.next;
            headNew = headNew.next;
        }
        while(temp1!=null){
            if(temp1.random == null)
                temp2.random = null;
            else{
                temp2.random = map.get(temp1.random.val);
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        return head;
    }
}