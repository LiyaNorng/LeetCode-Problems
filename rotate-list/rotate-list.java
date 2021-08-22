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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
      
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        
        int total = k % count;
        total = count - total;
        temp = head;
        ListNode prev = null;
        while(temp != null){
            prev = temp;
            temp = temp.next;
            total--;
            //System.out.println(total);
            if(total == 0){
                break;
            }
        }
        
        if(temp != null){
            prev.next = null;
            ListNode cur = head;
            head = temp;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = cur;
        }
        
        return head;
    }
}