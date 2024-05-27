package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2024/4/30
 * @Copyright: 2024 URBAN REVIVO . All rights reserved.
 */
public class 杨辉三角II {

    public static void main(String[] args) {
        System.out.println(generate(0));
        System.out.println(generate(1));
        System.out.println(generate(2));
        System.out.println(generate(3));
        System.out.println(generate(33));
    }

    public static List<Integer> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>( );

        result.add(Collections.singletonList(1));

        if (numRows <= 0) {
            return result.get(0);
        }


        for (int i = 1; i <= numRows; i++) {
            List<Integer> item = new ArrayList<>(i + 1);

            List<Integer> upLine = result.get(i-1);

            for (int j = 0; j <= i; j++) {
                item.add(getUpTwoItem(upLine,j));
            }

            result.add(item);
        }

        return result.get(numRows);
    }

    private static Integer getUpTwoItem(List<Integer> upLine, int nowIndex) {
        if(nowIndex==0 || nowIndex>=upLine.size()){
            return 1;
        }
        return upLine.get(nowIndex - 1) + upLine.get(nowIndex);
    }
}
