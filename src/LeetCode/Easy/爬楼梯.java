package LeetCode.Easy;

/**
 * @author: Gruuy
 * @remark:
 * @date: Create in 15:54 2019/11/15
 */
public class 爬楼梯 {
    public static void main(String[] args){
        System.out.println(climbStairs(8));
    }
    /** 斐波那契数列 */
    public static int climbStairs(int n) {
        //本质就是
        // 1只有一种  1
        // 2有两种  11 2
        // 3有3种   12 21 111 3
        // 4有5种   1111 112 121 211 22
        // 后一个等于前两个加起来  就是斐波那契数列  套公式就完了
        double sqrt_5 = Math.sqrt(5);
        double fib_n = Math.pow((1 + sqrt_5) / 2, n + 1) - Math.pow((1 - sqrt_5) / 2,n + 1);
        return (int)(fib_n / sqrt_5);
    }
}
