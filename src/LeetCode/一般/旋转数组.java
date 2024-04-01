package LeetCode.一般;

import java.util.Arrays;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2021/1/8
 * @Copyright: 2021 锦铭泰软件. All rights reserved.
 */
public class 旋转数组 {

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }


    public static void main(String[] args){
        int[] ints = {1};
        rotate(ints,0);
        System.out.println(Arrays.toString(ints));
    }
}
