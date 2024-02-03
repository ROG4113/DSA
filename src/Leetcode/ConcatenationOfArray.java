package Leetcode;

import java.util.Arrays;

public class ConcatenationOfArray {
    static int[] concatenate(int[] nums){
        int[] arr=new int[2*(nums.length)];
        for(int i=0; i<nums.length; i++){
            arr[i]=nums[i];
            arr[arr.length/2+i]=nums[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        int [] arr={1,2,1};
        System.out.println(Arrays.toString(concatenate(arr)));
    }
}
