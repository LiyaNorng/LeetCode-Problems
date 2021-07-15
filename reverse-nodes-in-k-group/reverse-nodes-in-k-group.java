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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(k == 0 || head == null){
            return head;
        }
        
        int i = k;
        ListNode prev = null;
        ListNode tail = head;
        ListNode cur = head;
        ListNode next = null;
        ListNode res = new ListNode(0);
        ListNode temp = res;
        while (cur != null){
            
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            i--;
            if(i == 0){
                temp.next = prev;
                temp = tail;
                prev = null;
                next = null;
                tail = cur;
                if (!check(cur, k)){
                    temp.next = cur;
                    //System.out.println("got here");
                    break;
                }
                i = k;
            }
        }
        
        if (prev != null){
            temp.next = prev;
        } 
        return res.next;
    }
    
    public boolean check(ListNode cur, int i){
        if (cur == null){
            return false;
        }
        
        while(cur != null && i > 0){
            i--;
            cur = cur.next;
        }
        return i == 0;
    }
    
}