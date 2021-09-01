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
    public ListNode partition(ListNode head, int x) {
        
        if (head == null){
            return null;
        }
      
        ListNode front = new ListNode(0);
        ListNode back = new ListNode(0);
        ListNode frontTemp = front;
        ListNode backTemp = back;
        
        while(head != null){
            if (head.val < x){
                frontTemp.next = head;
                frontTemp = frontTemp.next;
            }
            else{
                backTemp.next = head;
                backTemp = backTemp.next;
            }
            head = head.next;
        }
        backTemp.next = null;
        frontTemp.next = back.next;
        return front.next;
    }
}