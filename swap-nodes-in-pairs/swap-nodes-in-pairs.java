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
    public ListNode swapPairs(ListNode head) {
        
        
        if (head == null){
            return head;
        }
        
        ListNode cur = head;
        ListNode next = null;
        ListNode prev = null;
        ListNode tail = cur;
        ListNode res = new ListNode(0);
        ListNode temp = res;
        int k = 0;
        while(cur != null){
            
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            k++;
            if(k == 2){
                temp.next = prev;
                temp = tail;
                tail = cur;
                prev = null;
                k = 0;
            } 
        }
        if (prev != null){
            temp.next = prev;
        }
        return res.next == null ? head : res.next;
 
        /**
        if (head == null){
            return null;
        }
        else if (head.next == null){
            return head;
        }
        ListNode cur = head.next, res = null;
        ListNode prev = head;
        ListNode last = null;
        while(cur != null){
            if (last != null){
                last.next = null;
            }
            prev.next =  cur.next;
            cur.next = prev;
            if (res == null){
                res = cur;
            }
            if (last != null){
                last.next = cur;
            }
            if (prev.next == null){
                break;
            }
            last = prev;
            prev = prev.next;
            cur = prev;
            cur = cur.next;
        }
        return res; 
        
        
        **/
    }
}