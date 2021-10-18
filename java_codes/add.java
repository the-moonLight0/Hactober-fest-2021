class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;        
            
            int quotient = (num1 + num2 + carry) % 10;
            carry = (num1 + num2 + carry) / 10;

            if(head == null) {
                head = new ListNode(quotient);
                tail = head;
            } else {
                tail.next = new ListNode(quotient);
                tail = tail.next;
            }
            
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            
        }
        
        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        
        return head;
    }
}
