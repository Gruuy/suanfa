package LeetCode.Easy;

import java.util.Objects;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2024/4/19
 * @Copyright: 2024 URBAN REVIVO . All rights reserved.
 */
public class 二叉树的最小深度 {

    public static void main(String[] args) {
        TreeNode param = new TreeNode(0);
        param.right = new TreeNode( 1 );
        param.right.right = new TreeNode( 2 );

        System.out.println(minDepth(param) );
    }

    public static int minDepth(TreeNode root) {
        if(Objects.isNull(root)){
            return 0;
        }

        // 左空跑右  右空跑左。。
        if(Objects.isNull(root.left)){
            return minDepth(root.right) + 1;
        }

        if(Objects.isNull(root.right)){
            return minDepth(root.left) + 1;
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
