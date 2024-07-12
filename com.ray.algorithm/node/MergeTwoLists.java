package node;

import java.util.List;
import java.util.Objects;

/**
 * 【合并两个有序链表】
 *
 * @author shilei
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode(0);
        ListNode prv = temp;
        while (Objects.nonNull(list1) && Objects.nonNull(list2)) {
            int val1 = list1.val;
            int val2 = list2.val;
            if (val1 <= val2) {
                prv.next = list1;
                list1 = list1.next;
            } else {
                prv.next = list2;
                list2 = list2.next;
            }
            prv = prv.next;
        }
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }
        return temp.next;
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
