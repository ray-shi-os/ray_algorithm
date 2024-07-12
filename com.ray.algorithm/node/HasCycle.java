package node;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * 【链表是否有环】
 *
 * @author shilei
 */
public class HasCycle {

    /**
     * hash解法
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (Objects.nonNull(head)) {
            boolean add = set.add(head);
            if (Boolean.FALSE.equals(add)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return false;
        }
        ListNode right = head;

        ListNode left = head.next;
        while (right != left) {
            if (Objects.isNull(left) || Objects.isNull(left.next)) {
                return false;
            }
            right = right.next;
            left = left.next.next;
        }
        return true;
    }

    /**
     * 找环的入口 hash解法
     *
     * @param head
     * @return
     */
    public ListNode hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (Objects.nonNull(head)) {
            boolean add = set.add(head);
            if (Boolean.FALSE.equals(add)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    /**
     * 设两指针 fast，slow 指向链表头部 head 。
     * 令 fast 每轮走 2 步，slow 每轮走 1 步。
     * 执行以上两步后，可能出现两种结果：
     * 第一种结果： fast 指针走过链表末端，说明链表无环，此时直接返回 null。
     * 如果链表存在环，则双指针一定会相遇。因为每走 1 轮，fast 与 slow 的间距 +1，fast 一定会追上 slow 。
     * 第二种结果： 当fast == slow时， 两指针在环中第一次相遇。下面分析此时 fast 与 slow 走过的步数关系：
     * 设链表共有 a+b 个节点，其中 链表头部到链表入口 有 a 个节点（不计链表入口节点）， 链表环 有 b 个节点（这里需要注意，a 和 b 是未知数，例如图解上链表 a=4 , b=5）；设两指针分别走了 f，s 步，则有：
     * fast 走的步数是 slow 步数的 2 倍，即 f=2s；（解析： fast 每轮走 2 步）
     * fast 比 slow 多走了 n 个环的长度，即 f=s+nb；（ 解析： 双指针都走过 a 步，然后在环内绕圈直到重合，重合时 fast 比 slow 多走 环的长度整数倍 ）。
     * 将以上两式相减得到 f=2nb，s=nb，即 fast 和 slow 指针分别走了 2n，n 个环的周长。
     * 接下来该怎么做呢？
     * 如果让指针从链表头部一直向前走并统计步数k，那么所有 走到链表入口节点时的步数 是：k=a+nb ，即先走 a 步到入口节点，之后每绕 1 圈环（ b 步）都会再次到入口节点。而目前 slow 指针走了 nb 步。因此，我们只要想办法让 slow 再走 a 步停下来，就可以到环的入口。
     * 但是我们不知道 a 的值，该怎么办？依然是使用双指针法。考虑构建一个指针，此指针需要有以下性质：此指针和 slow 一起向前走 a 步后，两者在入口节点重合。那么从哪里走到入口节点需要 a 步？答案是链表头节点head。
     *
     * @param head
     * @return
     */
    public ListNode hasCycle3(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return null;
        }
        ListNode left = head;
        ListNode right = head;
        while (right != null) {
            if (Objects.isNull(right.next)) {
                return null;
            }
            left = left.next;
            right = right.next.next;

            if (left == right) {
                ListNode temp = head;
                while (temp != left) {
                    temp = head.next;
                    left = left.next;
                }
                return temp;
            }

        }

        return null;
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
