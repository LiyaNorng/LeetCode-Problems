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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        
        ListNode * head = new ListNode(0);
        ListNode * cur = head;
        
        int carry = 0;
        int sum = 0;
        
        while(l1 != NULL && l2 != NULL){
            sum = l1->val + l2->val + carry;
            carry = 0;
            if(sum > 9){
                carry = 1;
                sum -= 10;
            }
      
            ListNode * newNode = new ListNode(sum);
            cur->next = newNode;
            cur = newNode;
            l1 = l1->next;
            l2 = l2->next;
        }
        
        while(l1 != NULL){
            sum = l1->val + carry;
            carry = 0;
            if(sum > 9){
                carry = 1;
                sum -= 10;
            }
            ListNode * newNode = new ListNode(sum);
            cur->next = newNode;
            cur = newNode;
            l1 = l1->next;
        }
        
        while(l2 != NULL){
            sum = l2->val + carry;
            carry = 0;
            if(sum > 9){
                carry = 1;
                sum -= 10;
            }
            ListNode * newNode = new ListNode(sum);
            cur->next = newNode;
            cur = newNode;
            l2 = l2->next;
        }
        if(carry == 1){
            ListNode *newNode = new ListNode(carry);
            cur->next = newNode;
        }
        return head->next;
    }
};