package LeetCode.一般;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2020/7/29
 * @Copyright: 2020 锦铭泰软件. All rights reserved.
 */
public class 括号生成 {

    public static void main(String[] args) {
        ArrayList<String> result = new ArrayList<>( );
        generateParenthesis(result, new StringBuilder( ), 0, 0, 3);
        System.out.println(result.toString());
    }

    public static void generateParenthesis(List<String> result, StringBuilder item, int open, int close, int max) {
        if (item.length() == max * 2) {
            result.add(item.toString());
            return;
        }

        // 递归调用  括号都不会超过三个
        if (open < max) {
            item.append('(');
            generateParenthesis(result, item, open+1, close, max);
            item.deleteCharAt(item.length() - 1);
        }

        // 递归调用
        if (close < open) {
            item.append(')');
            generateParenthesis(result, item, open, close+1, max);
            item.deleteCharAt(item.length() - 1);
        }
    }
}
