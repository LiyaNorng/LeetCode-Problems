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
    void reorderList(ListNode* head) {
        stack<ListNode*> st;
        ListNode* cur = head;
        while(cur != NULL){
            st.push(cur);
            cur = cur->next;
        }
        ListNode* pass = head->next;
        cur = head;
        while(!st.empty() && cur != pass && cur != st.top()){
            cur->next = st.top();
            st.pop();
            cur = cur->next;
            cur->next = NULL;
            cur->next = pass;
            cur = pass;
            pass = pass->next;
            cur->next = NULL;
        }
        if(cur == pass){
            cur->next = pass;
            pass->next = NULL;
        }
        else if(cur == st.top()){
            cur->next = st.top();
            cur = cur->next;
            cur->next = NULL;
        }
    }
};