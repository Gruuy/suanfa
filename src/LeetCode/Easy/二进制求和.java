package LeetCode.Easy;

/**
 * @author: Gruuy
 * @remark:
 * @date: Create in 0:40 2019/11/13
 */
public class 二进制求和 {
    public static void main(String[] args){
        System.out.println(addBinary("1010", "1011"));
    }
    public static String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            // 判断j>=0的含义是有可能两个数字长度不一致，如果j<0的话则将其当做0来处理，否则获取其值，也就是 b.charAt(j) - '0'
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            //取mod只有0与1
            ans.append(sum % 2);
            //除2得是否进位
            ca = sum / 2;
        }
        //最后进位  反转输出
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }
}
