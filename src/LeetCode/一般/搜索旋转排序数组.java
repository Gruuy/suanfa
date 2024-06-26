package LeetCode.一般;

import java.util.Arrays;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2020/9/30
 * @Copyright: 2020 锦铭泰软件. All rights reserved.
 */
public class 搜索旋转排序数组 {
    public static void main(String[] args){
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    // 二分查找
    public static int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
