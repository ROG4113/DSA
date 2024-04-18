package Leetcode;

import java.util.Arrays;
import java.util.Stack;

public class L503{
    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st=new Stack<Integer>();
        int n=nums.length;
        int[] ans=new int[nums.length];
        for(int i=2*n-1; i>=0; i--){
            if(st.isEmpty()){
                ans[i%n]=-1;
            }
            else{
                int c=nums[i%n];
                if(c<st.peek()){
                    ans[i%n]=st.peek();
                }
                while(c>=st.peek()){
                    st.pop();
                    if(st.isEmpty()){
                        ans[i%n]=-1;
                        break;
                    }else ans[i%n]=st.peek();
                }
            }
            st.push(nums[i%n]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums={1,2,3,4,3};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}