package node;

import java.util.LinkedHashMap;
import java.util.Objects;

/**
 * 【LRU缓存-最少使用淘汰策略】
 * @author shilei
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;
    private ListNode listNode = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
       if (this.containsKey(key)) {
           listNode = handelListNode(listNode, key);
           return super.get(key);
       }
       return 0;
    }

    public void put(int key, int value) {
        if (this.containsKey(key)) {
            listNode = handelListNode(listNode, key);
        } else {

            if (this.size() >= capacity) {

                removeNode(listNode);

            }
            if (Objects.isNull(listNode)) {
                listNode = new ListNode(key);
            } else {
                listNode = new ListNode (key, listNode);
            }
        }
        super.put(key, value);
    }
    public void removeNode(ListNode listNode) {
        ListNode cur = listNode;
        if(cur.next == null) {
            this.remove( cur.val);
            listNode = null;
            return;
        }
        while (cur != null) {
            if (cur.next.next == null) {
                this.remove( cur.next.val);
                cur.next = null;
            }
            cur = cur.next;
        }
    }
    public ListNode handelListNode(ListNode listNode, int key) {
        ListNode cur = listNode;
        while (cur != null) {
            if (cur.next != null && cur.next.val == key) {
                ListNode node = cur.next;
                cur.next = cur.next.next;
                node.next = listNode;
                return node;

            }
            cur = cur.next;
        }
        return listNode;
    }


    public static class ListNode {
        int val;

        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        ListNode(int val) {
            this.val = val;
        }

    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(1);
        lRUCache.put(2, 1); // 缓存是 {1=1}
        lRUCache.get(2);    // 返回 1
        lRUCache.put(3, 2); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
    }
}
