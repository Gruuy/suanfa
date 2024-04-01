package LeetCode.Easy;

/**
 * @author: Gruuy
 * @remark:
 * @date: Create in 17:37 2019/11/9
 */
public class 最大子序和 {
    public static void main(String[] args){
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
    }

    /** 动态规划解法 */
    private static int maxSubArray(int[] nums) {
        //默认最大和为开头
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            //如果原本和大于0  则尝试添加
            if(sum > 0) {
                sum += num;
            }
            //如果和小于零则直接进行替换   重新计算字序和
            else {
                sum = num;
            }
            //最大子序和每次都与sum比较
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
