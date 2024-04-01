package LeetCode.Easy;

/**
 * @author: Gruuy
 * @remark:
 * @date: Create in 0:26 2019/11/6
 */
public class 实现strStr {
    public static void main(String[] args){
        System.out.println(strStr("hello","ll"));
    }
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
