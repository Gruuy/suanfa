package LeetCode.一般;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Gruuy
 * @remark:
 * @date: Create in 17:26 2019/10/25
 */
public class Z字形变换 {
    public static void main(String[] args){
        System.out.println(convert("LEETCODEISHIRING",3));
    }
//    public static String convert(String s, int numRows) {/
//        if(s==null||s.equals("")||numRows==1){
//            return s;
//        }
//        //一组有多少元素
//        //以每个Z上部分为基准  就是最长的一条(numRows)加上最长的一条-2
//        int count=numRows+numRows-2;
//        //那行数就是总长度/count  如果有余数需要+1  最后*numRows-1
//        int lie=(s.length()%count==0?s.length()/count:s.length()/count+1)*(numRows-1);
//        //通过二维数组画出图求解
//        char[][] c=new char[lie][numRows];
//        int lie1=-1,row=1;
//        for(int i=0;i<s.length();i++){
//            if(i%count==0){
//                row--;
//                lie1++;
//                c[lie1][row]=s.charAt(i);
//            }
//            else if(i%count<numRows){
//                row++;
//                c[lie1][row]=s.charAt(i);
//            }
//            else{
//                row--;
//                lie1++;
//                c[lie1][row]=s.charAt(i);
//            }
//        }
//        StringBuilder sb=new StringBuilder();
//        for(int i=0;i<numRows;i++){
//            for(int j=0;j<lie;j++){
//                sb.append(c[j][i]);
//            }
//        }
//        //  \u0000的意思是空  但是他是空字符插入字符串栈   而null是没有指向堆内存
//        return sb.toString().replace("\u0000","");
//    }

    public static String convert(String s, int numRows) {
        //间隔为1直接返回
        if (numRows == 1) return s;

        //初始化
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        //当前行
        int curRow = 0;
        //是否为底
        boolean goingDown = false;

        //遍历每个字符
        for (char c : s.toCharArray()) {
            //直接添加到可变类型中(一个就是一行)
            rows.get(curRow).append(c);
            //是否到底了  到了就变成false
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            //如果没有到底就+1  到了就开始-1
            curRow += goingDown ? 1 : -1;
        }

        //重新组合
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}
