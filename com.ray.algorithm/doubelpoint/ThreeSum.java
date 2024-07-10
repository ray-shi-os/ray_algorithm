package doubelpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int [] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(Arrays.toString(threeSum(nums).toArray()));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < length - 2 ; i++) {
            if (nums[i] > 0) {
                break;
            }
            int left = i + 1;
            int right = length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    while (left < right && nums[left] == nums[left+1]) {
                        left ++;
                    }
                    left ++;
                } else if (sum > 0) {
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                } else {
                    list.add(List.of(nums[i], nums[left], nums[right]));
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (left < right && nums[left] == nums[left+1]) {
                        left ++;
                    }
                    right--;
                    left ++;
                }
            }
        }
        return list;
    }
}
