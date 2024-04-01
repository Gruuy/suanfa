package LeetCode.一般;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Gruuy
 * @remark:
 * @date: Create in 9:27 2019/10/29
 */
public class 字符串转换整数 {
    public static void main(String[] args){
        System.out.println(myAtoi("2147483648"));
    }
    public static int myAtoi(String str) {
        //去首尾空格
        str=str.trim();
        //正负标记
        boolean flag=true;
        long s=0;
        //独立判断第一个字符
        if(str.equals("")) return 0;
        //先判断正负
        char captain=str.charAt(0);
        if(captain=='-') flag=false;
        else if(captain=='+') flag=true;
        //非数字或正负号
        else if(captain<48||captain>=58) return 0;
        //数字
        else if(captain>=48&&captain<58) s+=Integer.valueOf(String.valueOf(captain));
        //再搞其他的
        for(int i=1;i<str.length();i++){
            //大于小于直接中断
            if(s>Integer.MAX_VALUE){
                s=Integer.MAX_VALUE;
                break;
            }
            else if(s<Integer.MIN_VALUE){
                s=Integer.MIN_VALUE;
                break;
            }
            char str1=str.charAt(i);
            //移位=*10  同时判断非负数
            if(str1>=48&&str1<58) {
                s = flag ? s * 10 : Math.abs(s * 10) * -1;
                s += Integer.valueOf(String.valueOf(str1))*(flag?1:-1);
            }else {
                break;
            }
        }
        //利用long比int大  进行判断
        if(s>Integer.MAX_VALUE){
            s=Integer.MAX_VALUE;
        }
        if(s<Integer.MIN_VALUE){
            s=Integer.MIN_VALUE;
        }
        //返回又隐式转换为int
        return (int)s;
    }
}
