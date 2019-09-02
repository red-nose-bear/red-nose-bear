package list;


import list.base.ListNode;

/**
 * 输入一个链表，反转链表后，输出新链表的表头
 * 先保存next值，防止链表断掉
 * 然后当前指向pre，反转链表
 * pre=当前， 当前=next，进入下一个循环
 */

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}