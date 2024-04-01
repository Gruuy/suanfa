package LeetCode.Easy;

/**
 * @author: Gruuy
 * @remark:
 * @date: Create in 11:47 2019/10/28
 */
public class 整数翻转 {
    public static void main(String[] args){
        System.out.println(reverse(1534236469) );
    }
//    public static int reverse(int x) {
//        //防止溢出反转符号位溢出
//        String s=String.valueOf(Math.abs((long)x));
//        StringBuilder stringBuilder=new StringBuilder();
//        //反转
//        for(int i=s.length()-1;i>=0;i--){
//            stringBuilder.append(s.charAt(i));
//        }
//        //加进去
//        String str=x>0?stringBuilder.toString():"-"+stringBuilder.toString();
//        try {
//            return Integer.parseInt(str);
//        }catch (Exception e){
//            return 0;
//        }
//    }
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            //取最后一位
            int pop = x % 10;
            //之后去掉它
            x /= 10;
            //如果溢出
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            //如果反溢出
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            //这个是我们要的数
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
