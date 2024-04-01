package LeetCode.Easy;

import java.util.Arrays;

/**
 * @author: Gruuy
 * @remark:
 * @date: Create in 23:45 2019/11/5
 */
public class 删除排序数组中的重复项 {
    public static void main(String[] args){
        int[] nums={};
        System.out.println(removeDuplicates(nums));
        Arrays.stream(nums).forEach(a-> System.out.print(a ));
    }
    /** 官方双指针 */
    public static int removeDuplicates(int[] nums){
        //为零直接返回
        if (nums.length == 0) return 0;
        //定义指针i
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            //如果不相等
            if (nums[j] != nums[i]) {
                //i指针加一  并替换
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
//    public static int removeDuplicates(int[] nums) {
//        //0直接返回
//        if(nums.length==0) return 0;
//        //非0默认有1
//        int num=1;
//        for(int i=0;i<nums.length;i++){
//            //记录每个num  因为有序  如果等于最后一个肯定已经排完了
//            int j=nums[i];
//            if(j==nums[nums.length-1]) break;
//            for(int k=i;k<nums.length;k++){
//                //如果有间隔位就移动并break
//                if(nums[k]>j&&k-i>=1) {nums[i+1]=nums[k];num++;break;}
//            }
//        }
//        return num;
//    }
}
