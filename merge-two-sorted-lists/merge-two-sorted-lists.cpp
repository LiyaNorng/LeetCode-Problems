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
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        
        ListNode * head = new ListNode(0);
        ListNode * cur = head;
        
        while(l1 != NULL && l2 != NULL){
            if(l1->val > l2->val){
                cur->next = l2;
                cur = l2;
                l2 = l2->next;
                cur->next = NULL;
            }
            else{
                cur->next = l1;
                cur = l1;
                l1 = l1->next;
                cur->next = NULL;
            }
        }
        
        if(l1 != NULL){
            cur->next = l1;
        }
        
        if(l2 != NULL){
            cur->next = l2;
        }
        return head->next;
    }
};