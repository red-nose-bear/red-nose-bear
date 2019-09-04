package list;


import list.base.ListNode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则
 */

public class MergeTwoList {
    /**
     * 递归版本
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoList1(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null)
            return list2 == null ? list1 : list2;
        if (list1.val < list2.val) {
            list1.next = mergeTwoList1(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoList1(list1, list2.next);
            return list2;
        }
    }

    /**
     * 非递归版本
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoList2(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode head = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        if (list1 != null) {
            head.next = list1;
        }
        if (list2 != null) {
            head.next = list2;
        }
        return dummyNode.next;
    }
}
