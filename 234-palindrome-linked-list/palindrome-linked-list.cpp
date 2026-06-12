class Solution {
public:
    bool isPalindrome(ListNode* head) {
        stack<int> st;

        ListNode* slow = head;
        ListNode* fast = head;

        // Push first half into stack
        while (fast && fast->next) {
            st.push(slow->val);
            slow = slow->next;
            fast = fast->next->next;
        }

        // Odd length: skip middle node
        if (fast) {
            slow = slow->next;
        }

        // Compare second half with stack
        while (slow) {
            if (st.top() != slow->val) {
                return false;
            }

            st.pop();
            slow = slow->next;
        }

        return true;
    }
};