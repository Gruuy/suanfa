package LeetCode.一般;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: Gruuy
 * @remark:
 * @date: Create in 16:50 2019/10/24
 */
public class 无重复字符最长子串 {
    public static void main(String[] args){
        String s="abcabcbb";
        int n = s.length(), ans = 0;
        // current index of character
        //记录字符出现的最后一位下标
        Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [i, j]
        //i为元素的下标   j为当前下标
        for (int j = 0, i = 0; j < n; j++) {
            //如果hashmap里面已经有了当前元素
            if (map.containsKey(s.charAt(j))) {
                //i（这个元素的标记）与hashmap的下标进行比较   取较大者
                i = Math.max(map.get(s.charAt(j)), i);
            }
            //最长位数就是已经有的最长元素与现在进行比较(j-i就是无重复元素的开始  +1是因为0也算)
            ans = Math.max(ans, j - i + 1);
            //把这个元素的下标信息进行更新
            map.put(s.charAt(j), j + 1);
        }
    }
}
