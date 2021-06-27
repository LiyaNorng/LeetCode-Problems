/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    int carry = 0;
    int digit = 0;
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = null, head = null;
        while (l1 != null || l2 != null){
            if ( l1 == null){ addTwoNumber(0, l2.val); }
            else if (l2 == null){ addTwoNumber(l1.val, 0); }
            else { addTwoNumber(l1.val, l2.val); }
            if (head == null){
                pre = addNewNode(pre, digit);   
                head = pre;            
            }
            else{ pre = addNewNode(pre, digit); }
            if (l2 != null){ l2 = l2.next; } 
            if (l1 != null){ l1 = l1.next; } 
        }
        if (carry != 0){ pre = addNewNode(pre, carry); }  
        return head;
    }
    
    public ListNode addNewNode(ListNode pre, int value){
        ListNode temp = new ListNode(value);
        temp.next = null;
        if (pre == null){ pre = temp;}
        else{
            pre.next = temp;
            pre = temp;
        }
        digit = 0;
        return pre;
    }
    
    public void addTwoNumber(int left, int right){
        String total = String.valueOf(left + right + carry );
        carry = 0;
        if (total.length() > 1){
            carry = Character.getNumericValue(total.charAt(0));
            digit = Character.getNumericValue(total.charAt(1));
        }
        else { digit = Integer.parseInt(total); }
    } 
}