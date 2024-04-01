package LeetCode.一般;

import java.util.Arrays;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2020/9/29
 * @Copyright: 2020 锦铭泰软件. All rights reserved.
 */
public class 下一个排列 {
    public static void main(String[] args){
        int[] ints = {1, 2, 3};
        nextPermutation(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 找出相邻大于的位置
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        // 与位置最后的交换
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        // 换位后排序
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
