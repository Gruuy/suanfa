package LeetCode.一般;

import java.util.Arrays;

/**
 * @Description:
 * @author: Gruuy
 * @Email: 245746119@qq.com
 * @date: 2020/6/29
 * @Copyright: 2020 锦铭泰软件. All rights reserved.
 */
public class 盛水最多的容器 {

    public static void main(String[] args) {
        int[] item = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(String.valueOf(maxArea(item)));
    }

    /**
     * 双指针解法   小的往大的方向缩  求中间的面积
     * @param item
     * @return
     */
    public static int maxArea(int[] item) {
        int i = 0;
        int j = item.length - 1;
        int max = 0;
        while (i != j) {
            max = Math.max(max, Math.min(item[i], item[j]) * (j - i));
            if (item[i] <= item[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
