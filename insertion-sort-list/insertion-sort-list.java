/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode sort = null;
    public ListNode insertionSortList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode temp;
        while(head != null){
            temp = head;
            head = head.next;
            temp.next = null;
            sortList(temp);
        }
        
        return sort;
    }
    
    public void sortList(ListNode node){
        if(sort == null || sort.val >= node.val){
            node.next = sort;
            sort = node;
            return;
        }
        ListNode temp = sort;
        while(temp.next != null && temp.next.val < node.val){
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
    }
    
}