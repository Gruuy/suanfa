package LeetCode.Easy;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2024/5/29
 * @Copyright: 2024 URBAN REVIVO . All rights reserved.
 */
public class 验证回文串 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P") );
    }

    public static boolean isPalindrome(String s) {
        if(Objects.isNull(s) || s.equals("")){
            return true;
        }

        LinkedList<Character> list = new LinkedList<Character>(  );
        for (char c : s.toLowerCase().toCharArray( )) {
            if(!Character.isLetter(c) && !Character.isDigit(c)){
                continue;
            }

            list.addLast(c);
        }

        while (!list.isEmpty( )) {
            if (list.size( ) <= 1) {
                break;
            }

            Character head = list.removeFirst( );
            Character tail = list.removeLast( );

            if (head != tail) {
                return false;
            }
        }

        return true;
    }
}
