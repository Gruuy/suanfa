package LeetCode.Easy;

import java.util.Arrays;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2021/1/5
 * @Copyright: 2021 锦铭泰软件. All rights reserved.
 */
public class 一维数组的动态和 {

    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i] + result[i-1];
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(runningSum(new int[]{1, 2, 3, 4, 5})));
    }
}
