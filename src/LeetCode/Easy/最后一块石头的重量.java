package LeetCode.Easy;

import java.util.Arrays;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2020/12/30
 * @Copyright: 2020 锦铭泰软件. All rights reserved.
 */
public class 最后一块石头的重量 {

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{1,3}) );
    }

    public static int lastStoneWeight(int[] stones) {
        if(stones.length==1){
            return stones[0];
        }

        Arrays.sort(stones);

        int index = stones.length - 1;
        while (index>=1){
            int newNum = stones[index] - stones[index - 1];
            stones[index - 1] = newNum;
            stones[index] = Integer.MAX_VALUE;
            Arrays.sort(stones);
            index--;
        }

        return stones[0];
    }
}
