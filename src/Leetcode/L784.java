package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class L784{
    public static List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        boolean[] map = new boolean[arr.length];
        helper(0, sb, map, arr, ans);
        return ans;
    }

    private static void helper(int index, StringBuilder sb, boolean[] map, char[] arr, List<String> ans) {
        if (sb.length() == arr.length) {
            if(!ans.contains(sb.toString())){
                ans.add(new String(sb.toString()));
            }
            return;
        }
        sb.append(Character.toUpperCase(arr[index]));
        helper(index+1, sb, map, arr, ans);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(Character.toLowerCase(arr[index]));
        helper(index+1, sb, map, arr, ans);
        sb.deleteCharAt(sb.length() - 1);
    }
    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b2"));
    }
}