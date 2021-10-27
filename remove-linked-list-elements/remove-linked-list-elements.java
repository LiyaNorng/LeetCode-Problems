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
    public ListNode removeElements(ListNode head, int val) {
        
        if(head == null){
            return null;
        }
        
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode cur = head, temp = prev;
        
        while(cur != null){
            if(cur.val == val){
                cur = cur.next;
            }
            else{
                prev.next = cur;
                prev = prev.next;
                cur = cur.next;
            }
        }
        prev.next = cur;  
        return temp.next;
    }
}