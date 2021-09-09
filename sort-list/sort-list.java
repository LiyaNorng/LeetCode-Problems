/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        
        return mergeSort(head);   
    }
    
    public ListNode mergeSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode middle = getMiddle(head);
        ListNode nextOfMiddle = middle.next;
        middle.next = null;
        
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(nextOfMiddle);
        return sortMerge(left, right);
        
    }
    
    public ListNode sortMerge(ListNode left, ListNode right){
        
        if(left == null){
            return right;
        }
        
        if(right == null){
            return left;
        }
        
        ListNode temp = null;
        
        if(left.val <= right.val){
            temp = left;
            temp.next = sortMerge(left.next, right);
        }
        else{
            temp = right;
            temp.next = sortMerge(left, right.next);
        }
        return temp;
    }
    
    public ListNode getMiddle(ListNode head){
        if(head == null){
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }  
}