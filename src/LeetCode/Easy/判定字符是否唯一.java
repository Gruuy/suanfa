package LeetCode.Easy;

import java.util.BitSet;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2020/9/24
 * @Copyright: 2020 锦铭泰软件. All rights reserved.
 */
public class 判定字符是否唯一 {
    public static void main(String[] args){
        System.out.println(isUnique("abbnds"));
    }

    public static boolean isUnique(String astr) {
        BitSet bitSet = new BitSet( 26 );
        char[] chars = astr.toCharArray( );
        for (char aChar : chars) {
            boolean b = bitSet.get(aChar);
            if(b){
                return false;
            }
            bitSet.set(aChar,true);
        }
        return true;
    }
}
