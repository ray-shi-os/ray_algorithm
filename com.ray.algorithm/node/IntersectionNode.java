package node;

import java.util.Objects;

/**
 * 【相交链表】
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * 图示两个链表在节点 c1 开始相交：
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构
 *
 * @author shilei
 */
public class IntersectionNode {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (Objects.isNull(headA) || Objects.isNull(headB)) {
            return null;
        }

        while (Objects.nonNull(headA)) {
            ListNode node = headB;
            while (Objects.nonNull(node)) {
                if (headA == node)  {
                    return headA;
                }
                node = node.next;
            }
            headA = headA.next;
        }
        return null;

    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4);
        listNode4.next = listNode5;
        ListNode listNode8 = new ListNode(8);
        listNode8.next = listNode4;

        ListNode listNodeA1 = new ListNode(1);
        listNodeA1.next = listNode8;
        ListNode listNodeA14= new ListNode(4);
        listNodeA14.next = listNodeA1;

        ListNode listNodeB1 = new ListNode(1);
        listNodeB1.next = listNode8;
        ListNode listNodeB6 = new ListNode(6);
        listNodeB6.next = listNodeB1;
        ListNode listNodeB5 = new ListNode(5);
        listNodeB5.next = listNodeB6;

        ListNode intersectionNode = getIntersectionNode(listNodeA14, listNodeB5);
        System.out.println(intersectionNode.val);



    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
