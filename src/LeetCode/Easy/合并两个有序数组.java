package LeetCode.Easy;

import java.util.Arrays;

/**
 * @author: Gruuy
 * @remark:
 * @date: Create in 17:28 2019/11/21
 */
public class 合并两个有序数组 {
    public static void main(String[] args){
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        merge(nums1,3,nums2,3);
        Arrays.stream(nums1).forEach(a-> System.out.println(a ));
    }
    /** 从后往前 */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length==0){
            return;
        }
        //双指针
        m--;n--;
        int index=nums1.length-1;
        while (m>=0&&n>=0){
            if(nums1[m]>nums2[n]){
                nums1[index]=nums1[m--];
            }else {
                nums1[index]=nums2[n--];
            }
            index--;
        }
        //第二个数组大于0才要也弄过去   如果是第一个剩下的  则刚好有序
        while (n>=0){
            nums1[index]=nums2[n--];
            index--;
        }
    }

}
