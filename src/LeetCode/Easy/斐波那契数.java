package LeetCode.Easy;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2021/1/4
 * @Copyright: 2021 锦铭泰软件. All rights reserved.
 */
public class 斐波那契数 {

    public static int fib(int n) {
        switch (n){
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                int l2 = 0;
                int l1 = 1;
                int l = l1 + l2 ;
                for (int i = 2; i < n; i++) {
                    l2 = l1;
                    l1 = l;
                    l = l2 + l1;
                }
                return l;
        }
    }
    
    public static void main(String[] args){
        System.out.println(fib(4));
    }
}
