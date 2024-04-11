package Leetcode;

import java.util.HashMap;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        HashMap < Character, Integer > mpp = new HashMap < Character, Integer > ();
        int left = 0, right = 0;
        int max = 0;
        while (right < s.length()) {
            if (mpp.containsKey(s.charAt(right))){
                left = Math.max(mpp.get(s.charAt(right)) + 1, left);
            }
            mpp.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}