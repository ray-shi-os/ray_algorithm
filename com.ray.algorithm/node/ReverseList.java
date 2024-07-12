package node;

import java.util.Objects;

/**
 * 【反转链表】
 *
 * @author shilei
 */
public class ReverseList {

    public static void reverseList(ListNode head) {

        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;  // 保存下一个节点
            current.next = prev;          // 反转当前节点
            prev = current;               // 移动prev到当前节点
            current = nextTemp;           // 继续到下一个节点
        }

    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4);
        listNode5.next = listNode4;
        ListNode listNode8 = new ListNode(8);
        listNode4.next = listNode8;


        ListNode reverse = reverse(listNode5);


        System.out.println(reverse);
    }

    public static ListNode reverse(ListNode head) {
        ListNode reverse = null;
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        ListNode listNode = head.next;
        reverse = reverse(listNode);
        listNode.next = head;
        head.next = null;

        return reverse;
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
