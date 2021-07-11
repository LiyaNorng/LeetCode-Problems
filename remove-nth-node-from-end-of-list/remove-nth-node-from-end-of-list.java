/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int counter = 0;
        ListNode temp = head;
        
        while (true){
            if (temp == null){
                break;
            }
            counter++;
            temp = temp.next;
        }
        
        if (counter == 1){
            return null;
        }
        else if (counter == n){
            return head = head.next;
        }
        ListNode pre = head;
        temp = pre.next;
        int i = 1;
        while (true){
            if (counter - n == i){
                pre.next = temp.next;
                break;
            }
            if (temp == null){
                pre.next = null;
                break;
            }
            i++;
            pre = pre.next;
            temp = temp.next;
        }
        return head;
    }
}