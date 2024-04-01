package LeetCode.一般;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2020/12/18
 * @Copyright: 2020 锦铭泰软件. All rights reserved.
 */
public class 组合总和 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public static void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 深度优先
        dfs(candidates, target, ans, combine, idx + 1);

        // 到达树底，才进行判断
        // 选择当前数
        // 假设combinationSum(new int[]{2, 3, 5, 7},7)  idx = 3,target - candidates[idx] = 0,递归重进则add后return
        // 下一个  idx = 2,target - candidates[idx] = 2,递归条件 target - candidates[idx] = 2 - 7 < 0,则会从结果集中删除
        // 而到下个 idx=1  也会删除，因为3+5/3+7都大于7
        //
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }

    public static void main(String[] args){
        System.out.println(combinationSum(new int[]{2, 3, 5, 7},7));
    }
}
