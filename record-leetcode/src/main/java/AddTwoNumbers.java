public class AddTwoNumbers {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyNode;
        int carry = 0;
        while (p != null || q != null) {
            int x = p == null ? 0 : p.val;
            int y = q == null ? 0 : q.val;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }
        if (carry > 0 ) {
            curr.next = new ListNode(carry);
        }

        return dummyNode.next;
    }
}
