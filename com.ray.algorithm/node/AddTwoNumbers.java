package node;

import java.util.Objects;

/**
 * 【两个链表相加】
 *
 * @author shilei
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode pre = node;
        int temp = 0;
        while (l1 != null || l2 != null) {
            int val1 = Objects.isNull(l1) ? 0 : l1.val;
            int val2 = Objects.isNull(l2) ? 0 : l2.val;
            int sum = val1 + val2 + temp;
            temp = sum / 10;
            sum = sum % 10;
            pre.next = new ListNode(sum);
            pre = pre.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if(temp > 0) {
            pre.next = new ListNode(temp);
        }

        return node.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode pre = node;
        for (int i = 1; i < 10; i++) {
            pre.next = new ListNode(i);
            pre = pre.next;
        }
        System.out.println(node);
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
