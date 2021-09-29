/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        
        if(head == NULL){
            return head;
        }
        ListNode* slow = head;
        ListNode* fast = slow;
        
        while(fast != NULL && fast->next != NULL){
            
            slow = slow->next;
            fast = fast->next->next;
            if(fast == slow){
                break;
            }
        }
        
        slow = head;
        
        while(fast != NULL && fast->next){
            if(slow == fast){
                return slow;
            }
            slow = slow->next;
            fast = fast->next;
        }
        
        return NULL;
    }
};