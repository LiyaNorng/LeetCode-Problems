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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if(lists.size() == 1){
            return lists[0];
        }
        if(lists.size() == 0){
            return NULL;
        }
        int j = 0;
        int i = 0;
        int len = lists.size() - 1;
        
        while(len != 0){
            j = len;
            i = 0;
            while(i < j){
                lists[i] = merge(lists[i], lists[j]);
                j--;
                i++;
                if(i >= j){
                    len = j;
                }
            }
        }
        
        return lists[0];
    }
    
    
    ListNode * merge(ListNode* left, ListNode* right){
        ListNode* head = new ListNode(0);
        ListNode* cur = head;
        
        while(left != NULL && right != NULL){
            if(left->val > right->val){
                cur->next = right;
                cur = right;
                right = right->next;
                cur->next = NULL;
            }
            else{
                cur->next = left;
                cur = left;
                left = left->next;
                cur->next = NULL;
            }
        }
        
        if(left != NULL){
            cur->next = left;
        }
        
        if(right != NULL){
            cur->next = right;
        }
        
        return head->next;
    }
};