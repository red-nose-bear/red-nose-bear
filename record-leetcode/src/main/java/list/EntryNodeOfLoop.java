package list;

import list.base.ListNode;

/**
 * 链表
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * ----------------
 * 思路：
 * 两个结论：
 * 1、设置快慢指针，假如有环，他们最后一定相遇。
 * 2、两个指针分别从链表头和相遇点继续出发，每次走一步，最后一定相遇与环入口。
 * 证明1：设置快慢指针fast和low，fast每次走两步，low每次走一步。假如有环，两者一定会相遇（因为low一旦进环，可看作fast在后面追赶low的过程，每次两者都接近一步，最后一定能追上）。
 * 证明2：图：https://uploadfiles.nowcoder.com/images/20180615/4240377_1529033184336_9A253E69EDBB4FD57BB16FC3A32C2756
 * 设：
 * 链表头到环入口长度为--a
 * 环入口到相遇点长度为--b
 * 相遇点到环入口长度为--c
 * <p>
 * 则：相遇时
 * 快指针路程=a+(b+c)k+b ，k>=1  其中b+c为环的长度，k为绕环的圈数（k>=1,即最少一圈，不能是0圈，不然和慢指针走的一样长，矛盾）。
 * 慢指针路程=a+b
 * 快指针走的路程是慢指针的两倍，所以：
 * （a+b）*2=a+(b+c)k+b
 * 化简可得：
 * a=(k-1)(b+c)+c 这个式子的意思是： 链表头到环入口的距离=相遇点到环入口的距离+（k-1）圈环长度。其中k>=1,所以k-1>=0圈。所以两个指针分别从链表头和相遇点出发，最后一定相遇于环入口。
 * ----------------
 */

public class EntryNodeOfLoop {

    public ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                // 快慢指针相遇
                p2 = pHead;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        return null;
    }

}