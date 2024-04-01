package LeetCode.一般;

import java.util.Arrays;

/**
 * @Description:
 * @author: Gruuy
 * @Email: 245746119@qq.com
 * @date: 2020/7/3
 * @Copyright: 2020 锦铭泰软件. All rights reserved.
 */
public class 最接近的三数之和 {
    public static void main(String[] args) {
        int[] nums = {-3,-2,-5,3,-4};
        System.out.println(threeSumClosest(nums, -1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length <= 0) {
            return 0;
        }

        // 先排序
        Arrays.sort(nums);
        // 注意  不能用最大的integer  因为结果如果是MinValue  会变成负数
//        int best = Integer.MAX_VALUE;
        int best = 100000000;

        for (int a = 0; a < nums.length; ++a) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }

            int b=a+1;
            int c=nums.length -1;

            while (c > b) {
                int sum = nums[a] + nums[b] + nums[c];
                if ( sum > target) {
                    c--;
                }

                if (sum < target){
                    b++;
                }

                if (sum == target){
                    best = sum;
                    break;
                }
                if (Math.abs(best-target)>Math.abs(sum-target)){
                    best=sum;
                }
            }
        }

        return best;
    }
}
