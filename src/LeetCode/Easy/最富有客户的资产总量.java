package LeetCode.Easy;

import java.util.Arrays;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2021/1/4
 * @Copyright: 2021 锦铭泰软件. All rights reserved.
 */
public class 最富有客户的资产总量 {

    public static int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int[] account = accounts[i];
            int asInt = 0;
            for (int i1 : account) {
                asInt+=i1;
            }
            max = Math.max(asInt,max);
        }
        return max;
    }
    
    public static void main(String[] args){
        System.out.println(maximumWealth(new int[][]{{2,8,7}, {7,1,3}, {1,9,5}}));
    }
}
