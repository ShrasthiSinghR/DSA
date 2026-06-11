class Solution {
public:
    ListNode* middleNode(ListNode* head) {

        int size = 0;
        ListNode* temp = head;

        while(temp != NULL) {
            size++;
            temp = temp->next;
        }

        temp = head;

        for(int i = 0; i < size/2; i++) {
            temp = temp->next;
        }

        return temp;
    }
};