package LeetCode.困难;

/**
 * @Description:
 * @author: Gruuy
 * @Email: 245746119@qq.com
 * @date: 2020/6/25
 * @Copyright: 2020 锦铭泰软件. All rights reserved.
 */
public class 正则表达式匹配 {

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];

        // 默认都为空时   初始化为true
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {

                // 假设正则带*
                if (p.charAt(j - 1) == '*') {
                    // 它的匹配结果  就是前一个字符的匹配结果
                    f[i][j] = f[i][j - 2];

                    // 再判断一下字符是否匹配
                    if (matches(s, p, i, j - 1)) {
                        // 只要当前匹配结果为true或与前一个匹配结果为true  就是为true
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                }

                // 不带*的话  是最简单的字符匹配字符
                else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }

        // 返回匹配结果
        return f[m][n];
    }

    /**
     * 判断字符是否匹配
     * @param s
     * @param p
     * @param i
     * @param j
     * @return
     */
    public static boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aab", "c*a*b"));
    }
}
