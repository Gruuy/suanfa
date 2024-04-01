package LeetCode.一般;

/**
 * @author: Gruuy
 * @remark:
 * @date: Create in 15:52 2019/10/25
 */
public class 最长回文子串 {
    public static void main(String[] args){
        System.out.println(longestPalindrome("babad") );
//        String s="babad";

    }
    /**
    //现在为马拉车算法
    //马拉车算法是   给它加分隔符  那样无论总长度是奇还是偶  最终出来的都是计数（缝隙也有了分隔元素）
    //之后就可以直接进行中心求最大了
    */
    public static String longestPalindrome(String s) {
        //为空直接返回
        if (s == null || s.length() < 1) return "";
        //添加分隔符
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<s.length();i++){
            stringBuilder.append("#");
            stringBuilder.append(s.charAt(i));
        }
        stringBuilder.append("#");
        s=stringBuilder.toString();

        int start = 0, end = 0;
        //循环每个元素
        for (int i = 0; i < s.length(); i++) {
            //计算回文子串（中心单元素）
            int len = expandAroundCenter(s, i, i);
//            //双元素
//            int len2 = expandAroundCenter(s, i, i + 1);
            //比较长度
//            int len = Math.max(len1, len2);
            //如果比现有的回文子串大  就把新得到的回文子串坐标接入
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1).replace("#","");
    }
    /**左右扩展方法*/
    private static int expandAroundCenter(String s, int left, int right) {
        //单元素第一个是自己  双元素是相邻的
        int L = left, R = right;
        //循环条件是   left与right没有超界  且对应的字符相等
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        //返回他们的长度(右减左-1)
        return R - L - 1;
    }
}
