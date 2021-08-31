/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private ListNode left;
    private boolean done;
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null){
            return null;
        }
        this.left = head;
        this.done = false;
        ListNode cur = head;
        reverse(cur, m, n);
        return head;
    }
    
    public void reverse(ListNode right, int m , int n){
        if (n == 1){
            return;
        }
        
        right = right.next;

        if (m > 1){
            this.left = this.left.next;
        }
        this.reverse(right, m - 1, n - 1);
        
        if(this.left == right || this.left == right.next){
            this.done = true;
        }
        
        if(!this.done){
            int temp = right.val;
            right.val = this.left.val;
            this.left.val = temp;
            this.left = this.left.next;   
        }
    }    
}