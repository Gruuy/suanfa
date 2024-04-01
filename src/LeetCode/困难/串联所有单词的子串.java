package LeetCode.困难;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2020/9/25
 * @Copyright: 2020 锦铭泰软件. All rights reserved.
 */
public class 串联所有单词的子串 {
    public static void main(String[] args){
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(findSubstring(s, words));
    }

    /**
     * 前提： words每个单词长度一样.
     * @param s
     * @param words
     * @return
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>( );
        if (s == null || s.length( ) == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>( );

        // 初始化map
        int one_word = words[0].length( );
        int word_num = words.length;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }


        for (int i = 0; i < one_word; i++) {
            // 左右窗口
            int left = i, right = i, count = 0;
            HashMap<String, Integer> tmp_map = new HashMap<>( );

            // 检测单词是否出现
            while (right + one_word <= s.length( )) {
                String w = s.substring(right, right + one_word);
                right += one_word;
                // 单词不存在   窗口清空跳过
                if (!map.containsKey(w)) {
                    count = 0;
                    left = right;
                    tmp_map.clear( );
                } else {
                    // 赋值  如果次数超过  从超过的
                    tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
                    count++;
                    // 超词的时候  窗口挪动
                    while (tmp_map.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
                        String t_w = s.substring(left, left + one_word);
                        count--;
                        tmp_map.put(t_w, tmp_map.getOrDefault(t_w, 0) - 1);
                        left += one_word;
                    }
                    // 匹配时添加
                    if (count == word_num) res.add(left);
                }
            }
        }
        return res;
    }
}
