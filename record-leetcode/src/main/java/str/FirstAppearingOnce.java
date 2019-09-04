package str;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。如果当前字符流没有存在出现一次的字符，返回#字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * ----------------
 * 思路：
 * 用哈希表记录字符出现的次数
 * 用string记录字符
 * 遍历string，找到第一个只出现一次的字符
 */

public class FirstAppearingOnce {
    Map<Character, Integer> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();

    //Insert one char from stringstream
    public void insert(char ch) {
        map.computeIfPresent(ch, (k, v) -> map.get(k) + 1);
        map.putIfAbsent(ch, 1);
        sb.append(ch);
    }

    //return the first appearence once char in current stringstream
    public char firstAppearingOnce() {
        int len = sb.length();
        for (int i=0; i<len; i++) {
            if (map.get(sb.charAt(i)) == 1)
                return sb.charAt(i);
        }
        return '#';
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.computeIfPresent("a", (k, v) -> v + 2);
        System.out.println(map.get("a"));

        FirstAppearingOnce firstAppearingOnce = new FirstAppearingOnce();
        String s = "google";
        char[] chars = s.toCharArray();
        for (char c:chars) {
            firstAppearingOnce.insert(c);
            char c1 = firstAppearingOnce.firstAppearingOnce();
            System.out.print(c1);
        }
    }
}