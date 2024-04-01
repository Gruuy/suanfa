package LeetCode.困难;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2020/12/29
 * @Copyright: 2020 锦铭泰软件. All rights reserved.
 */
public class 按要求补齐数组 {

    public static void main(String[] args){
        System.out.println(minPatches(new int[]{1,5,10},20) );
    }

    public static int minPatches(int[] nums, int n) {
        // 当[1,x-1]可以全覆盖时，[1,x+nums[index]-1]一样可以全覆盖
        // 假设x不能覆盖nums索引下的数
        // 就可以假设他添加一个数之后   可以覆盖所有数
        // 即数量+1  而无需求数是多少。
        int patches = 0;
        long x = 1;
        int length = nums.length, index = 0;
        while (x <= n) {
            if (index < length && nums[index] <= x) {
                x += nums[index];
                index++;
            } else {
                x *= 2;
                patches++;
            }
        }
        return patches;
    }

}
