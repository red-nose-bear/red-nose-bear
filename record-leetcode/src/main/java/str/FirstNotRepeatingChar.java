package str;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符, 并返回它的位置, 如果没有则返回 -1（需要区分大小写）
 */

public class FirstNotRepeatingChar {

    public int firstNotRepeatingChar(String str) {
        if (str == null || str == "")
            return -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++)
            map.put(str.charAt(i), map.get(str.charAt(i)) == null ? 1 : map.get(str.charAt(i)) + 1);
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1)
                return i;
        }

        return -1;
    }

}
