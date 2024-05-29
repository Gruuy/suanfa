package LeetCode.Easy;

public class 只出现一次的数字 {

    public static void main(String[] args) {
        int[] params = {2, 2, 1};
//        System.out.println(singleNumber(params));
        System.out.println(singleNumberFastest(params));

        params = new int[]{4, 1, 2, 1, 2};
//        System.out.println(singleNumber(params));
        System.out.println(singleNumberFastest(params));

        params = new int[]{1};
//        System.out.println(singleNumber(params));
        System.out.println(singleNumberFastest(params));
    }

    public static int singleNumber(int[] nums) {
        everyRank:
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] == nums[j]) {
                    continue everyRank;
                }
            }

            return nums[i];
        }

        return -1;
    }

    public static int singleNumberFastest(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
