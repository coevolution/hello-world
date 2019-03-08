package longestsubstringwithoutrepeat;

import com.johnlu.exercise.MathTools;

import java.util.Arrays;
import java.util.List;

public class LongestSubstringWithoutRepeatMain {
    private static char[] chars = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public static void main(String[] args) {
        LongestSubStringWithoutRepeatVersion1 l = new LongestSubStringWithoutRepeatVersion1();
        int[] i1 = MathTools.randomSort(0,9);
        int[] i2 = MathTools.randomSort(0,9);
        int[] i3 = MathTools.randomSort(15,25);
        StringBuilder sb = new StringBuilder();
        Arrays.stream(i1).forEach(i -> sb.append(chars[i]));
        Arrays.stream(i2).forEach(i -> sb.append(chars[i]));
        Arrays.stream(i3).forEach(i -> sb.append(chars[i]));
        System.out.println("字符串:"+sb);
        long length = l.lengthOfLongestSubstring(String.valueOf(sb));
        System.out.println("最长子字符串长度为"+length);
    }
}
