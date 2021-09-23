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
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null){
            return;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        Stack<ListNode> stack = new Stack<>();
        
        fast = slow;
        while(fast != null){
            stack.push(fast);
            fast = fast.next;
        }
 
        slow = head;
        ListNode nex = null;
        while(slow != null){
            nex = slow.next;
            if(stack.isEmpty()){
                slow = nex;
                break;
            }
            slow.next = stack.pop();
            slow = slow.next;
            slow.next = nex;
            slow = nex;
        }
        slow.next = null;
    }
}