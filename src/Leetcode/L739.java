package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class L739 {
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<Integer>();
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        int[] nge = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            if (st.isEmpty()) {
                nge[i] = 0;
                map.put(temperatures[i], i);
                st.push(temperatures[i]);
            } 
            else {
                if(temperatures[i]<st.peek()){
                    nge[i]=map.get(st.peek());
                }
                while (temperatures[i] >= st.peek()) {
                    st.pop();
                    if (st.isEmpty()) {
                        nge[i] = 0;
                        break;
                    } else nge[i]=map.get(st.peek());
                }
                map.put(temperatures[i], i);
                st.push(temperatures[i]);
            }
        }
        for (int i = 0; i < temperatures.length; i++) {
            if(nge[i]!=0){
                temperatures[i] = nge[i] - i;
            }else temperatures[i]=0;
        }
        return temperatures;
    }
    public static void main(String[] args) {
        int[] arr={73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(arr)));
    }
}
