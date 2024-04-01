package LeetCode.Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2024/3/21
 * @Copyright: 2024 URBAN REVIVO . All rights reserved.
 */
public class 二叉树的中序遍历 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode( 2 );
        a.right = new TreeNode( 3 );
        a.left.left = new TreeNode( 4 );
        a.left.right = new TreeNode( 5 );

        System.out.println(inorderTraversal(a));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>(  );

        if(Objects.isNull(root)){
            return resultList;
        }

        centerForeach(root,resultList);

        return resultList;
    }

    private static void centerForeach(TreeNode root, List<Integer> resultList) {
        if(Objects.nonNull(root.left)){
            centerForeach(root.left,resultList);
        }

        resultList.add(root.val);

        if(Objects.nonNull(root.right)){
            centerForeach(root.right,resultList);
        }
    }


    public static class TreeNode {
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
}
