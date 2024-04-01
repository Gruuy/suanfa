package LeetCode.困难;

import java.util.Stack;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2020/9/29
 * @Copyright: 2020 锦铭泰软件. All rights reserved.
 */
public class 最长有效括号 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(())"));
    }

    public static int longestValidParentheses(String s) {
//        int result = 0;
//        int max = 0;
//        LinkedList<Character> stack = new LinkedList<>( );
//        char[] chars = s.toCharArray( );
//        for (int i = 0; i < chars.length; i++) {
//            char aChar = chars[i];
//            if (aChar == '(' ) {
//                stack.add(aChar);
//            }
//            if (aChar == ')' && stack.size( ) > 0) {
//                stack.removeLast( );
//                result += 2;
//            }
//            if (stack.size( ) == 0 && ((i + 1 < chars.length && chars[i + 1] == ')')|| i == chars.length-1)) {
//                max = Math.max(result, max);
//                result = 0;
//            }
//        }
//        return max;
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

}
