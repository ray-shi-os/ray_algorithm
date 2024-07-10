package doubelpoint;

import java.util.Arrays;

/**
 * 【双指针-移动零】
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 *
 * @author shilei
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {1,11,19,29,0, 8, 0,7,8};
        System.out.println(Arrays.toString(moveZeroes(nums)));
    }

    public static int[] moveZeroes(int[] nums) {
        int length = nums.length;
        int right = 0;
        int left = 0;
        while (right < length) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left ++;
            }
            right ++ ;
        }
        return nums;
    }


}
