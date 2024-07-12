package node;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 【回文链表】
 *
 * @author shilei
 */
public class Palindrome {

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (Objects.nonNull(head)) {
            list.add(head.val);
            head = head.next;
        }
        int left = 0;

        int right = list.size() - 1;

        while (left < right) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            } else {
                left ++ ;
                right --;
            }
        }
        return true;
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
