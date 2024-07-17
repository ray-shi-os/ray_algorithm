package node;

import java.util.*;

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

    public  void nums(int[] nums) {
        int right = 0;
        int left = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left ++;
            }
            right++;
        }
    }

    public int area(int[] nums) {
        int left = 0;

        int right = nums.length - 1;
        int area = 0;

        while (left < right) {
            area = Math.max(area, (right-left) * Math.min(nums[left], nums[right]));
            if (nums[left + 1] > nums[right -1]) {
                left ++;
            } else {
                right --;
            }
        }
        return area;
    }

    public List<List<Integer>> sum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < length - 2; i++) {
            if (nums[i] > 0) {
                return list;
            }
            if (i >0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    while (left < right &&  nums[right] == nums[right-1]) {
                        right --;
                    }
                    right --;
                }

                if (sum < 0) {
                    while (left < right &&  nums[left] == nums[left+1]) {
                        left++;
                    }
                    left++;
                }
                if (sum == 0) {
                    list.add(List.of(nums[i],  nums[left], nums[right]));
                    while (left < right &&  nums[left] == nums[left+1]) {
                        left++;
                    }
                    left++;
                    while (left < right &&  nums[right] == nums[right-1]) {
                        right--;
                    }
                    right--;
                }
            }

        }
        return list;
    }
    public int[] sum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target- nums[i];
            if (map.containsKey(key)) {
                return new int[]{map.get(key), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    public int[] sum1(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right =length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            }
            int nextLeft = nums[left + 1];
            int nextRight= nums[right - 1];
            if (sum < target) {
                if (nextLeft > nextRight) {
                    left ++;
                } else {
                    right--;
                }
            }
            if (sum > target) {
                if (nextLeft > nextRight) {
                    right -- ;
                } else {
                    left++;
                }
            }
        }
        return new int[]{};
    }

    public int getMaxSoreLength(int[] nums) {
        Arrays.sort(nums);
        int max = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i]-1;
            if (map.containsKey(key)) {
                int value = map.get(key) + 1;
                max = Math.max(max, value);
                map.put(nums[i],value);
            } else {
                map.put(nums[i], 1);
            }
        }
        return max;
    }

    public String test(String s) {
        // 特殊用例判断
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
