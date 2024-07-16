package node;

/**
 * @author shilei
 */
public class SwapPairs {
    public static ListNode swapPairs(ListNode head) {
        ListNode listNode = new ListNode(0, head);
        ListNode cur = head;
        ListNode pre = listNode;
        while (cur != null && cur.next != null) {
            ListNode node1 = cur;
            ListNode node2 = cur.next;
            node1.next = node2.next;
            node2.next = node1;
            pre.next = node2;
            cur = node2.next.next;
            pre = pre.next.next;
        }
        return listNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        ListNode listNode1 = swapPairs(listNode);
        System.out.println(listNode1);
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
