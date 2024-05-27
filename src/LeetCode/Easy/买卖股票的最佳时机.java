package LeetCode.Easy;

import java.util.Arrays;

public class 买卖股票的最佳时机 {

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4};
        System.out.println(maxProfit(ints));

        ints = new int[]{4, 3, 2, 1};
        System.out.println(maxProfit(ints));
    }

    public static int maxProfit(int[] prices) {
        if(prices.length<=0){
            return 0;
        }

        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
