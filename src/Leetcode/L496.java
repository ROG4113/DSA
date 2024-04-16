package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class L496 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st=new Stack<Integer>();
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        int[] arr=new int[nums2.length];
        for(int i=nums2.length-1; i>=0; i--){
            map.put(nums2[i], i);
            if(st.isEmpty()){
                arr[i]=-1;
            }
            else{
                if(nums2[i]<st.peek()){
                    arr[i]=st.peek();
                }
                while(nums2[i]>=st.peek()){
                    st.pop();
                    if(st.isEmpty()){
                        arr[i]=-1;
                        break;
                    } else arr[i]=st.peek();
                }
            }
            st.push(nums2[i]);
        }
        System.out.println(Arrays.toString(arr));
        int[] ans=new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            ans[i]=arr[map.get(nums1[i])];
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums1={1,3,5,2,4};
        int[] nums2={6,5,4,3,2,1,7};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
}
