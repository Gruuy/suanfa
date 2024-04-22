package LeetCode.Easy;

import java.util.Objects;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2024/4/23
 * @Copyright: 2024 URBAN REVIVO . All rights reserved.
 */
public class 路径总和 {

    public static void main(String[] args) {
        TreeNode item = new TreeNode(1);
        item.left = new TreeNode( 2 );
        item.right = new TreeNode( 3 );

        System.out.println(hasPathSum(item,3) );
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(Objects.isNull(root)){
            return false;
        }

        if(targetSum==root.val && Objects.isNull(root.left) && Objects.isNull(root.right)){
            return true;
        }

        return hasPathSum(root.left,targetSum - root.val) || hasPathSum(root.right,targetSum - root.val);
    }
}
