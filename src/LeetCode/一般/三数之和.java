package LeetCode.一般;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @author: Gruuy
 * @Email: 245746119@qq.com
 * @date: 2020/6/30
 * @Copyright: 2020 锦铭泰软件. All rights reserved.
 */
public class 三数之和 {
    public static void main(String[] args) {
        int[] test = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(test);
        lists.forEach(a -> {
            System.out.print("[");
            a.forEach(x-> System.out.print(x+","));
            System.out.println("]");
        });
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>( );

        // 第一个数
        for (int i = 0; i < nums.length; ++i) {
            // 如果已经大于0了  直接结束（排序后  第一个数永远最小）
            if (nums[i] > 0) {
                return ans;
            }
            // 重复则跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // c 对应的指针初始指向数组的最右端
            int third = nums.length - 1;
            int target = -nums[i];

            // 枚举 b
            for (int second = i + 1; second < nums.length - 1; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > i + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }

        }

        return ans;
    }
}
