package Leetcode;

import java.util.Arrays;

public class ShuffleTheArray {
    static public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[2*n];
        for(int i=0; i<n/2-1; i++){
            arr[i]=nums[i];
            for(int j=n/2; j<=2*n; j++){
                arr[i+1]=nums[j];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[]arr={2,5,1,3,4,7};
        System.out.println(Arrays.toString(shuffle(arr, 3)));
    }
}
