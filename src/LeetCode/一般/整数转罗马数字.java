package LeetCode.一般;

/**
 * @Description:
 * @author: Gruuy
 * @Email: 245746119@qq.com
 * @date: 2020/6/30
 * @Copyright: 2020 锦铭泰软件. All rights reserved.
 */
public class 整数转罗马数字 {
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    /**
     * 利用穷举  从大至小进行除运算   直到除尽为止
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        StringBuilder result = new StringBuilder( );
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romaNums = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] <= num) {
                num -= nums[i];
                result.append(romaNums[i]);
            }
        }

        return result.toString( );
    }
}
