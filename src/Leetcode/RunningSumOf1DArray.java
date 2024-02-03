package Leetcode;

import java.util.Arrays;

public class RunningSumOf1DArray {
    static int[] sum(int[] nums){
        int[] arr=new int[nums.length];
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            arr[i]=sum;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr={0, 0, 0};
        System.out.println(Arrays.toString(sum(arr)));
    }
}
