package longestsubstringwithoutrepeat;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatVersion1 {
    private static Map<Character, Integer> alphabets = new LinkedHashMap() {

    };

    public long lengthOfLongestSubstring(String s) {
        String sentinel = s;
        long returnLength = 0;
        long oldPosition = returnLength;
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        for (int i = 0, j = 0; i < s.length(); i++) {

            if (sMap.containsKey(s.charAt(i))) {
                if (j <= sMap.get(s.charAt(i)) + 1) {
                    j = sMap.get(s.charAt(i)) + 1;
                }
                oldPosition = (Integer) sMap.get(s.charAt(i));
                System.out.println("出现重复字符" + s.charAt(i) + " 位置为" + (i + 1));
                //System.out.println("子字符串:"+s.substring());
            }
            sMap.put(s.charAt(i), i);
            returnLength = Math.max(returnLength, i - j + 1);
        }
        return returnLength;
    }
}
