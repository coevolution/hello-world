package palindromic;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LongestSubString {
    public String longestPalindrome(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        int middle = length / 2 + 1;
        int before = middle-1;
        int after = middle+1;
//        while()
        Stack stack = new Stack();
        stack.push(before);
        stack.push(after);
        synchronized (middle) {

        }

        return null;

    }
}
