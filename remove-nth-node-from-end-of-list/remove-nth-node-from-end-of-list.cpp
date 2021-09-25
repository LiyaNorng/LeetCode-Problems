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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        int len = 0;
        
        ListNode* cur = head;
        
        while(cur != NULL){
            len++;
            cur = cur->next;
        }
        
        cur = head;
        ListNode* prev = NULL;
        n = len - n;
        len = 0;
        while(cur != NULL){
            if(len == n){
                if(prev == NULL){
                    return head->next;
                }
                else{
                    prev->next = cur->next;
                    return head;
                }
            }
            prev = cur;
            cur = cur->next;
            len++;
        }
        return head;
    }
};