package LeetCode.Easy;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2020/9/29
 * @Copyright: 2020 锦铭泰软件. All rights reserved.
 */
public class 相同的树 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode( 2 );
        a.right = new TreeNode( 3 );
        System.out.println(isSameTree(a, a));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}