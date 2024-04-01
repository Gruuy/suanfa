package LeetCode.一般;

import java.util.Arrays;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2020/10/14
 * @Copyright: 2020 锦铭泰软件. All rights reserved.
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args){
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 0)));
    }

    public static int[] searchRange(int[] nums, int target) {
        if(nums.length==0){
            return new int[]{-1,-1};
        }
        if(nums.length==1 && target == nums[0]){
            return new int[]{0,0};
        }

        int[] result = new int[]{-1,-1};

        int left = 0;
        int right = nums.length - 1;
        int center = nums.length / 2;
        while (left<=right){
            if(nums[center] == target){
                result[0] = findBorder(nums,center,0);
                result[1] = findBorder(nums,center,1);
                break;
            }
            if(nums[center]>target) {
                right = center - 1;
            }
            else if (nums[center]<target) {
                left = center + 1;
            }

            if(right - left == 1 && nums[left] != target && nums[right] != target){
                break;
            }

            center = left + (right - left) / 2;
        }

        return result;
    }

    /**
     * 查找边界
     * @param nums
     * @param center
     * @param i
     * @return
     */
    private static int findBorder(int[] nums, int center, int i) {
        int num = nums[center];
        switch (i){
            case 0:
                while (center>0){
                    if(num != nums[--center]) {
                        center++;
                        break;
                    }
                }
                break;
            case 1:
                while (center<nums.length - 1){
                    if(num != nums[++center]) {
                        center--;
                        break;
                    }
                }
                break;
        }

        return center;
    }

}
