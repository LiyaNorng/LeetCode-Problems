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
    ListNode* swapPairs(ListNode* head) {
        if(head == NULL || head->next == NULL ){
            return head;
        }
        ListNode* prev = new ListNode(0);
        ListNode* cur = head;
        ListNode* next = NULL;
        head = prev;
        while(cur != NULL && cur->next != NULL){
            next = cur->next;
            prev->next = next;
            cur->next = next->next;
            next->next = cur;
            prev = cur;
            cur = cur->next;
        }
        return head->next;
    }
};