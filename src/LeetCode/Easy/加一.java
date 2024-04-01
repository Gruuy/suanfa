package LeetCode.Easy;

import java.util.Arrays;

/**
 * @author: Gruuy
 * @remark:
 * @date: Create in 0:22 2019/11/13
 */
public class 加一 {
    public static void main(String[] args){
        int[] ints={9,9,9};
        Arrays.stream(plusOne(ints)).forEach(a-> System.out.println(a ));
    }
    /** 从后向前判断  如果0位也进了  直接新建数组  默认所有都是0 改第一个就行 */
    public static int[] plusOne(int[] digits) {
        boolean flag=true;
        int index=digits.length-1;
        while (flag){
            if(index<0){
                digits=new int[digits.length+1];
                digits[0]=1;
                return digits;
            }
            flag=false;
            int i=digits[index];
            if((i+1)%10==0){
                digits[index]=0;
                flag=true;
                index--;
            }else {
                digits[index]=i+1;
            }
        }
        return digits;
    }
}
