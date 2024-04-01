package LeetCode.一般;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2020/7/16
 * @Copyright: 2020 锦铭泰软件. All rights reserved.
 */
public class 四数之和 {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1,0,-1,0,-2,2}, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>( );

        // 第一个数
        for (int i = 0; i < nums.length; ++i) {

            // 第二个数
            for (int j = i + 1; j < nums.length; ++j) {

                // d 对应的指针初始指向数组的最右端
                int four = nums.length - 1;
                int negate = target - (nums[j] + nums[i]);


                // 枚举 c
                for (int third = j + 1; third < nums.length - 1; ++third) {

                    // 需要保证 c 的指针在 d 的指针的左侧
                    while (third < four && nums[third] + nums[four] > negate) {
                        --four;
                    }
                    // 如果指针重合，随着 c 后续的增加
                    // 就不会有满足 a+b+c+d=target 并且 c<d 的 d 了，可以退出循环
                    if (third == four) {
                        break;
                    }

                    if (nums[third] + nums[four] == negate) {
                        List<Integer> list = new ArrayList<Integer>( );
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[third]);
                        list.add(nums[four]);
                        ans.add(list);
                    }
                }
            }
        }
        // 去重
        ans = ans.stream( )
                .map(a -> {
                    String s = a.toString( );
                    return s.substring(1, s.length( ) - 1);
                }).distinct( ).map(a -> {
                    String[] split = a.split(",");
                    List<Integer> result = new ArrayList<>( );
                    for (String s : split) {
                        result.add(Integer.valueOf(s.trim()));
                    }
                    return result;
                }).collect(Collectors.toList( ));

        return ans;
    }
}
