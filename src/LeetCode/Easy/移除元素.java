package LeetCode.Easy;

import java.util.Arrays;

/**
 * @author: Gruuy
 * @remark:
 * @date: Create in 0:08 2019/11/6
 */
public class 移除元素 {
    public static void main(String[] args){
        int[] nums={1,1,2,3,1,1,1,1};
        System.out.println(removeElement(nums, 1));
        Arrays.stream(nums).forEach(a-> System.out.print(a ));
    }

    /** 正反指针 */
    public static int removeElement(int[] nums,int val){
        //正反指针
        int i = 0;
        int n = nums.length;
        while (i < n) {
            //正指针如果相等就与最后替换  把要删除的都换到最后   到时候全部换成倒数第二个
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
    /** 双指针 */
//    public static int removeElement(int[] nums, int val) {
//        if(nums.length==0) return 0;
//        //不相等就加到i对应索引   相等不管
//        int i=0;
//        for(int j=0;j<nums.length;j++){
//            if(nums[j]!=val){
//                nums[i]=nums[j];
//                i++;
//            }
//        }
//        return i;
//    }
}
