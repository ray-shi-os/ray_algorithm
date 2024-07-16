package node;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 【删除链表的倒数第 N 个结点】
 *
 * @author shilei
 */
public class RemoveNthFromEnd {

    /**
     * 计算链表长度
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 0;
        ListNode headSize = head;
        while (headSize != null) {
            headSize = headSize.next;
            i++;
        }
        int j = i - n;
        ListNode node = new ListNode(0);
        ListNode pre = node;
        int k = 0;
        while (head != null) {
            if (k == j) {
                pre.next = head.next;
                return node.next;
            }
            k++;
            pre.next = head;
            pre = pre.next;
            head = head.next;
        }
        return node.next;
    }

    /**
     * 压栈
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        Deque<ListNode> deque = new LinkedList<>();
        ListNode listNode = new ListNode(0, head);
        ListNode cur = listNode;
        while (cur != null) {
            deque.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            deque.pop();
        }

        ListNode peek = deque.peek();
        peek.next = peek.next.next;
        return listNode.next;


    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
