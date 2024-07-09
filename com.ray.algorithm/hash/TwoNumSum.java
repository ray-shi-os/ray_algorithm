package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 【两数之和】
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * @author shilei
 */
public class TwoNumSum {
    public static void main(String[] args) {
        int[] twoNumSumHash = twoNumSumHash(new int[]{3, 3}, 6);
        int[] twoNumSum = twoNumSum(new int[]{3, 3}, 6);

        System.out.println(Arrays.toString(twoNumSumHash));
        System.out.println(Arrays.toString(twoNumSum));
    }

    /**
     * 暴力解法
     *
     * @param nums   nums
     * @param target target
     * @return int[]
     */
    public static int[] twoNumSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] + nums[i] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * 利用hash解法时间复杂度降低，空间复杂度增加
     *
     * @param nums nums
     * @param target target
     * @return int[]
     */
    public static int[] twoNumSumHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
