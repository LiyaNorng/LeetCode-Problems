/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    bool isPalindrome(ListNode* head) {
        
        if(head->next == NULL){
            return true;
        }
        ListNode* slow = head;
        ListNode* fast = head->next;
        
        while(fast != NULL && fast->next != NULL){
            slow = slow->next;
            fast = fast->next->next;
        }
        fast = slow->next;
        slow->next = NULL;
        ListNode* cur = NULL;
        ListNode* temp = NULL;
        
        while(fast != NULL){
            temp = fast;
            fast = fast->next;
            temp->next = cur;
            cur = temp;
        }
        
        while(head != NULL && cur != NULL){
            if(head->val != cur->val){
                return false;
            }
            head = head->next;
            cur = cur->next;
        }
        
        if(head != NULL && head->next != NULL && head->next->next != NULL){
            return false;
        }
        else if(cur != NULL && cur->next != NULL && cur->next->next != NULL){
            return false;
        }
        return true;
    }
};