package LeetCode.Easy;

/**
 * @author: Gruuy
 * @remark:
 * @date: Create in 15:36 2019/10/29
 */
public class 最长公共前缀 {
    public static void main(String[] args){
        String[] strings={"acc","aaa","aaba"};
        System.out.println(longestCommonPrefix(strings));
    }
//    public static String longestCommonPrefix(String[] strs) {
//        //为空  只有一个的直接返回
//        if(strs.length==0) return "";
//        if(strs.length==1) return strs[0];
//        //前缀长度默认为0
//        int prefix=0;
//        //比较的字符串
//        String s=strs[0];
//        String s1="";
//        //遍历
//        for(int i=1;i<strs.length;i++){
//            s1=strs[i];
//            //中间如果有为空的也直接返回
//            if(s1.equals("")||s.equals("")) return "";
//            //每次遍历这个东西要归零
//            prefix=0;
//            //只需要遍历可能达到范围
//            for(int j=0;j<(s1.length()>s.length()?s.length():s1.length());j++){
//                //匹配上了就+1
//                if(s.charAt(j)==s1.charAt(j))
//                    prefix+=1;
//                //第一个都没有直接return
//                else if(j==0) {
//                    return "";
//                //没有就关闭
//                }else
//                    break;
//            }
//            s=s.substring(0,prefix);
//        }
//        return s;
//    }

    public static String longestCommonPrefix(String[] strs) {
        //为空直接返回
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            //如果没有找到公共子串
            while (strs[i].indexOf(prefix) != 0) {
                //那就子串-1  缩小继续匹配
                prefix = prefix.substring(0, prefix.length( ) - 1);
                //缩到没有就return
                if (prefix.isEmpty( )) return "";
            }
        }
        return prefix;
    }
}
