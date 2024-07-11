package Leetcode;

import java.util.Stack;

public class L1190 {
    public static String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        char[] arr = s.toCharArray();
        for (char ch : arr) {
            if (ch == '(') {
                st.push(sb.length());
            } else if (ch == ')') {
                reverse(sb, st.pop(), sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    private static void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, temp);
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
    }
}
