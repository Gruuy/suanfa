package LeetCode.Easy;

import sun.text.resources.hr.FormatData_hr_HR;

/**
 * @author: Gruuy
 * @remark:
 * @date: Create in 14:47 2019/11/15
 */
public class x的平方根 {
    public static void main(String[] args){
//        System.out.println(mySqrt(999999999));
        System.out.println(niudunSqrt(8));
    }
    /** 二分法 */
    public static int mySqrt(int x) {
        // 注意：针对特殊测试用例，例如 2147395599
        // 要把搜索的范围设置成长整型
        // 为了照顾到 0 把左边界设置为 0
        long left = 0;
        // # 为了照顾到 1 把右边界设置为 x // 2 + 1
        long right = x / 2 + 1;
        while (left < right) {
            // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
            // long mid = left + (right - left + 1) / 2;
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        // 因为一定存在，因此无需后处理
        return (int) left;
    }
    /** 牛顿法 */
    public static int niudunSqrt(int a){
        //求得切线公式为(x+(a/x))/2   一直迭代范围即可
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }
}
