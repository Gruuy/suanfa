package LeetCode.Easy;

/**
 * @author: Gruuy
 * @remark:
 * @date: Create in 0:24 2019/11/7
 */
public class 报数 {
    public static void main(String[] args){
        System.out.println(countAndSay(5));
    }
    public static String countAndSay(int n) {
        //存放初始1
        StringBuilder stringBuilder=new StringBuilder("1");
        //从2开始才有循环  否则直接返回
        for(int i=2;i<=n;i++){
            //转成字符数组
            char[] chars = stringBuilder.toString( ).toCharArray( );
            //删除掉所有原本的内容
            stringBuilder.delete(0,stringBuilder.length());
            //默认第一个字符已有   计数为1
            int count=1;
            char c=chars[0];
            //循环整个数组   如果有符合的就count+1
            for(int j=1;j<chars.length;j++){
                if(c==chars[j]) count++;
                //不相等的话就重新开始计数
                else {
                    stringBuilder.append(count);
                    stringBuilder.append(c);
                    c=chars[j];
                    count=1;
                }
            }
            //最后循环完的加上去
            stringBuilder.append(count);
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
