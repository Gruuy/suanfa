package LeetCode.Easy;

/**
 * @author: Gruuy
 * @remark:
 * @date: Create in 0:13 2019/11/13
 */
public class 最后一个单词的长度 {
    public static void main(String[] args){
        System.out.println(lengthOfLastWord("a"));
    }
    /** 为空而且j=0的时候  空格不计 */
    public static int lengthOfLastWord(String s) {
        int j=0;
        for(int i=s.length()-1;i>=0;i--){
            if(j==0&&s.charAt(i)==' ') continue;
            if(s.charAt(i)==' '){
                break;
            }
            j++;
        }
        return j;
    }
}
