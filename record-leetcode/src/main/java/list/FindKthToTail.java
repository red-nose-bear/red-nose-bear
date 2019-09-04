package list;


import list.base.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点
 * 保证后指针为前指针起第k个元素
 */
public class FindKthToTail {

    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k <= 0)
            return null;
        ListNode pre = head;
        ListNode next = head;
        for (int i = 1; i < k; i++) {
            if (pre.next == null)
                return null;
            pre = pre.next;
        }

        while (pre.next != null) {
            pre = pre.next;
            next = next.next;
        }
        return next;
    }
}
