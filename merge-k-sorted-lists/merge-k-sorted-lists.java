/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if (lists == null){
            return null;
        }
        
        /**
        
        ListNode head = null;
        ListNode cur = null, prevC = null;
        ListNode newNode;
        for (ListNode temp : lists){
            if(head == null){
                head = new ListNode(0);
                head.next = temp;
                cur = null;
                temp = null;
            }
            else{
                prevC = head;
                cur = head.next;
            }
            while(temp != null){
                while(cur != null && cur.val <= temp.val){
                    prevC = cur;
                    cur = cur.next;
                }
                prevC.next = temp;
                temp = temp.next;
                prevC.next.next = cur;
                prevC = prevC.next;
            }
        }
        return head == null ? null : head.next;
        
        **/
        
        PriorityQueue<ListNode> queue = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        for (ListNode node : lists){
            while(node != null){
                queue.add(node);
                node = node.next;
            }
        }
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while(!queue.isEmpty()){
            cur.next = queue.poll();
            cur = cur.next;
        }
        cur.next = null;
        return res.next;
    }
}