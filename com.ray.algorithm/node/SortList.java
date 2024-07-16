package node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 【链表排序】
 *
 * @author shilei
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Object[] array = list.toArray();
        Arrays.sort(array);
        ListNode listNode = new ListNode(0);
        ListNode pre = listNode;
        for (int i = 0; i < array.length; i++) {
            pre.next = new ListNode((Integer) array[i]);
            pre = pre.next;
        }
        return listNode.next;

    }

    public ListNode sortList1(ListNode head) {
        ListNode listNode = null;
        int i = 0;
        while (head != null) {
            if (i == 0) {
                listNode = new ListNode(head.val);
            } else {
                listNode = merge(listNode, new ListNode(head.val));
            }
            i++;
            head = head.next;
        }
        return listNode;
    }

    public ListNode sort(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }

        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != tail) {}
            fast = fast.next;
        }
        ListNode dim = slow;
        ListNode listNode1 = sort(head, dim);
        ListNode listNode2 = sort(dim, tail);
        return merge(listNode1, listNode2);

    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode listNode = new ListNode(0);
        ListNode pre = listNode;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                pre.next = head1;
                head1 = head1.next;
            } else {
                pre.next = head2;
                head2 = head2.next;
            }
            pre = pre.next;
        }
        if (head1 != null) {
            pre.next = head1;
        }
        if (head2 != null) {
            pre.next = head2;
        }
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
