package LeetCode.一般;

import java.util.*;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2020/7/16
 * @Copyright: 2020 锦铭泰软件. All rights reserved.
 */
public class 电话号码的字母组合 {
    public static void main(String[] args){
        System.out.println(letterCombinations("23"));
    }

    /** 缓存 */
    private static final Map<String,String> cache = getCacheMap();

    /**
     * 返回的方法
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0){
            return new ArrayList<>(  );
        }
        //进行调用
        return getString("",digits);
    }

    private static List<String> getString(String oldStr,String chars){
        // 为0时，直接结束
        if(chars==null||chars.length()==0){
            return Collections.singletonList(oldStr);
        }

        // 每次取输入字符串的第一个值
        String number = chars.substring(0,1);
        String item = cache.get(number);
        List<String> result = new ArrayList<>(  );


        for (char c : item.toCharArray( )) {
            // 如果剩余的长度已经是1了  直接添加结尾  无需继续递归

            if(chars.length()==1) {
                result.add(oldStr.concat(String.valueOf(c)));
            }

            // 剩余长度字符串还需要继续进行递归调用
            else {
                result.addAll(getString(oldStr.concat(String.valueOf(c)), chars.substring(1)));
            }
        }
        return result;
    }

    /**
     * 初始化数字键缓存
     * @return
     */
    private static Map<String, String> getCacheMap() {
        Map<String, String> map = new HashMap<>(  );
        map.put("2","abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        return map;
    }
}
