package LeetCode.Easy;

import java.util.Arrays;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2024/4/7
 * @Copyright: 2024 URBAN REVIVO . All rights reserved.
 */
public class 将有序数组转换为二叉搜索树 {

    public static void main(String[] args) {
        int[] param = new int[]{0,1,2};
        TreeNode treeNode = sortedArrayToBST(param);
        System.out.println(treeNode );
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        int index = nums.length / 2;

        TreeNode result = new TreeNode(nums[index]);

        if (index == 0) {
            return result;
        }

        result.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,index));
        result.right = sortedArrayToBST(Arrays.copyOfRange(nums,index+1,nums.length));

        return result;
    }
}
