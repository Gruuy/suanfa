package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2024/6/4
 * @Copyright: 2024 URBAN REVIVO . All rights reserved.
 */
public class 二叉树的后序遍历 {

    public static void main(String[] args) {
        TreeNode param = new TreeNode(1);
        param.left = new TreeNode(2);
        param.right = new TreeNode(3);
        param.left.left = new TreeNode(4);

        System.out.println(postorderTraversal(param));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>( );
        }

        List<Integer> result = new ArrayList<>( );

        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);

        return result;
    }
}
