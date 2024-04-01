package LeetCode.一般;

import java.util.Map;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2020/9/19
 * @Copyright: 2020 锦铭泰软件. All rights reserved.
 */
public class 两数相除 {
    public static void main(String[] args){
        System.out.println(divide(-2147483648, 1));
    }
    public static int divide(int dividend, int divisor) {
        int flag = 1;

        if(Math.abs((long)divisor) > Math.abs((long)dividend)){
            return 0;
        }
        if((divisor < 0 && dividend>0) || (dividend<0 && divisor>0)){
            flag = -1;
        }

        long i = 0;
        if(Math.abs(divisor)!=1) {
            long sor = Math.abs((long) divisor);
            long end = Math.abs((long) dividend);
            while (end >= sor) {
                i += 1;
                end -= sor;
            }
        }else {
            i = Math.abs((long) dividend);
        }

        long result = flag == 1 ?  i : -i;
        if(result>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(result<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)result;
    }
}
