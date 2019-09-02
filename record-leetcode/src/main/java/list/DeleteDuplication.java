package list;

import list.base.ListNode;

/**
 * 链表：删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * -----------------
 * 思路：
 * 排序的链表，说明只会有连续的节点重复，不会有间断的节点重复
 * 1. 设置一个哑节点指向头节点
 * 2. 设置两个节点first指向不重复的节点，second当作工作节点向后扫描
 * -----------------
 */

public class DeleteDuplication {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode dummyNode = new ListNode(-1);
        ListNode first = dummyNode;
        first.next = pHead;
        ListNode second = pHead;

        while (second != null && second.next != null) {
            if (second.val == second.next.val) {
                // 重复节点，找到和该节点重复的所有节点
                while (second.next != null && second.val == second.next.val) {
                    second = second.next;
                }
                first.next = second.next;
            } else {
                // 节点不重复
                first = first.next;
            }
            second = second.next;
        }
        return dummyNode.next;
    }

}