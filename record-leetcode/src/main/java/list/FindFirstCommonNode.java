package list;


import list.base.ListNode;

/**
 * 链表：思维
 * 输入两个链表，找出它们的第一个公共结点。
 */

public class FindFirstCommonNode {

    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (p1 != p2) {
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }

        return p1;
    }

}
