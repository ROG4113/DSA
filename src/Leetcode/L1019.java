package Leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class L1019 {
    public static ArrayList<Integer> nextLargerNodes(ArrayList<Integer> list) {
        ArrayList<Integer> li = new ArrayList<Integer>();
        Stack<Integer> st = new Stack<Integer>();
        for (int i = list.size() - 1; i >= 0; i--) {
            int c = list.get(i);
            if (st.isEmpty()) {
                li.add(0, 0);
            } else {
                int p = st.peek();
                if (c < p) {
                    li.add(0, p);
                } else {
                    while ((c >= p)) {
                        st.pop();
                        if(st.isEmpty()) break;
                        p = st.peek();
                    }
                    if (!st.isEmpty()) {
                        li.add(0, st.peek());
                    } else li.add(0, 0);
                }
            }
            st.push(c);
        }
        return li;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(3);
        // list.add(4);
        // list.add(3);
        // list.add(5);
        System.out.println(nextLargerNodes(list));
    }
}
