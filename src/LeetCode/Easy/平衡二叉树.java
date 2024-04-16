package LeetCode.Easy;

import java.util.Objects;

public class 平衡二叉树 {

    public static void main(String[] args) {

//        TreeNode a = new TreeNode(1);
//        a.left = new TreeNode(2);
//        a.right = new TreeNode(2);
//        a.left.left = new TreeNode(3);
//        a.left.right = new TreeNode(3);
//        a.left.left.left = new TreeNode(4);
//        a.left.left.right = new TreeNode(4);

        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.left = new TreeNode(4);
        a.left.right = new TreeNode(5);
        a.right.left = new TreeNode(6);
        a.left.left.left = new TreeNode(8);

        System.out.println(isBalanced(a));
    }

    public static boolean isBalanced(TreeNode root) {
        if(Objects.isNull(root)){
            return true;
        }

        return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
