package LeetCode.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2020/12/18
 * @Copyright: 2020 锦铭泰软件. All rights reserved.
 */
public class 找不同 {

    public static char findTheDifference(String s, String t) {
        char[] sChars = s.toCharArray( );
        char[] tChars = t.toCharArray( );
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        for (int i = 0; i < s.length( ); i++) {
            if(sChars[i] != tChars[i]){
                return tChars[i];
            }
        }

        return tChars[s.length()];
    }

    public static void main(String[] args){
        System.out.println(findTheDifference("","a") );
    }
}
