package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Gruuy
 * @remark:
 * @date: Create in 15:03 2019/10/29
 */
public class 罗马数字转整数 {
    public static void main(String[] args){
        System.out.println(romanToInt("MCMXCIV"));
    }
    public static int romanToInt(String s) {
        //把所有可能出现的组合存放到hash
        Map<String,Integer> number=new HashMap<>(16);
        number.put("I",1);
        number.put("V",5);
        number.put("X",10);
        number.put("L",50);
        number.put("C",100);
        number.put("D",500);
        number.put("M",1000);
        number.put("IV",4);
        number.put("IX",9);
        number.put("XL",40);
        number.put("XC",90);
        number.put("CD",400);
        number.put("CM",900);

        //遍历计算
        int sum=0;
        String s1="";
        for(int i=0;i<s.length();i++){
            //有双字出现的最多去到最后一位减一
            if(i<s.length()-1){
                //判断每个双字是否可以获取到值
                s1=s.substring(i,i+2);
                if(number.get(s1)!=null) {
                    sum+=number.get(s1);i++;
                }
                //不行则相加
                else{
                    sum+=number.get(String.valueOf(s.charAt(i)));
                }
            //最后一个就直接相加
            }else{
                sum+=number.get(String.valueOf(s.charAt(i)));
            }
        }
        return sum;
    }
}
