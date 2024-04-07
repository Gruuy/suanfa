package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2024/3/26
 * @Copyright: 2024 URBAN REVIVO . All rights reserved.
 */
public class 对称二叉树 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(2);
        a.left.left = new TreeNode(3);
        a.left.right = new TreeNode(4);
        a.right.left = new TreeNode(4);
        a.right.right = new TreeNode(3);

//        System.out.println(isSymmetric(a));
        System.out.println(check(a,a));
    }

    public static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }


    public static boolean isSymmetric(TreeNode root) {
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            return true;
        }

        String leftSout = getTreeNodeResult(root.left, true);
        String rightSout = getTreeNodeResult(root.right, false);

        return leftSout.equals(rightSout);
    }

    private static String getTreeNodeResult(TreeNode root, boolean reserve) {
        List<Integer> result = new ArrayList<>( );
        getSonForeach(root, result, reserve);
        return result.toString( );
    }

    private static void getSonForeach(TreeNode node, List<Integer> result, boolean reserve) {
        if (Objects.isNull(node)) {
            result.add(Integer.MAX_VALUE);
            return;
        }

        result.add(node.val);

        if (reserve) {
            getSonForeach(node.left, result, reserve);

            getSonForeach(node.right, result, reserve);
        } else {
            getSonForeach(node.right, result, reserve);

            getSonForeach(node.left, result, reserve);
        }
    }

}
