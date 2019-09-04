package list;

import list.base.RandomListNode;

/**
 * 链表 - 复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head
 * <p>
 * 思路：
 * 1. 根据原始链表的每个节点N创建对应的节点N'，并把N'连在N后面
 * 2. 设置随机指针，即：A.next.randomNext = A.randomNext.next
 * 3. 将两个链表断开：奇数位置连接起来的为原链表，偶数位置连接起来的为复制链表
 */

public class CloneRandomListNode {

    public RandomListNode clone(RandomListNode pHead) {
        // 1. 根据原始链表的每个节点N创建对应的节点N'，并把N'连在N后面
        cloneNodes(pHead);

        // 2. 设置随机指针，即：A.next.randomNext = A.randomNext.next
        setRandomRefOfCloneNode(pHead);

        // 3. 将两个链表断开：奇数位置连接起来的为原链表，偶数位置连接起来的为复制链表
        return splitNodes(pHead);
    }

    private RandomListNode splitNodes(RandomListNode pHead) {
        RandomListNode node = pHead;
        RandomListNode cloneHead = null;
        RandomListNode cloneNode = null;
        // 第一个节点
        if (node != null) {
            cloneHead = node.next;
            cloneNode = node.next;
            node.next = cloneNode.next;
            node = cloneNode.next;
        }
        // 分开链表
        while (node != null) {
            cloneNode.next = node.next;
            cloneNode = cloneNode.next;
            node.next = cloneNode.next;
            node = node.next;
        }

        return cloneHead;
    }

    private void setRandomRefOfCloneNode(RandomListNode pHead) {
        RandomListNode node = pHead;
        while (node != null) {
            if (node.random != null)
                node.next.random = node.random.next;
            node = node.next.next;
        }
    }

    private void cloneNodes(RandomListNode pHead) {
        RandomListNode node = pHead;
        while (node != null) {
            RandomListNode cloneNode = new RandomListNode(node.label);
            cloneNode.next = node.next;
            node.next = cloneNode;
            node = cloneNode.next;
        }
    }

}

