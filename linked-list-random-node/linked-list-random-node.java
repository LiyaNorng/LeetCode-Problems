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

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    
    ListNode head;
    Random random;
    
    public Solution(ListNode head) {
        random = new Random();
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        
        int r = head.val;
        ListNode cur = head.next;
        int i = 1;
        while(cur != null){
            i++;
            if(random.nextInt(i) == 0){
                r = cur.val;
            }
            cur = cur.next;
        }
        return r;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */