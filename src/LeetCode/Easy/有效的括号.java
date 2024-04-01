package LeetCode.Easy;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: Gruuy
 * @remark:
 * @date: Create in 16:47 2019/10/29
 */
public class 有效的括号 {
    public static void main(String[] args){
        System.out.println(isValid("]"));
    }
    public static boolean isValid(String s) {
        //初始化栈
        Stack<Character> stack=new Stack<>();
        char a;
        //对应压栈出栈
        for(int i=0;i<s.length();i++){
            a=s.charAt(i);
            switch (a){
                case '(':
                case '[':
                case '{':
                    stack.push(a);
                    break;
                case ')':
                    if(stack.size()>0&&stack.peek()=='(') stack.pop();
                    else return false;
                    break;
                case ']':
                    if(stack.size()>0&&stack.peek()=='[') stack.pop();
                    else return false;
                    break;
                case '}':
                    if(stack.size()>0&&stack.peek()=='{') stack.pop();
                    else return false;
                    break;
            }
        }
        //循环完如果栈还有东西就是不对
        if(stack.size()>0) return false;
        return true;
    }

}
