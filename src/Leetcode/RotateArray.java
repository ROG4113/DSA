package Leetcode;

import java.util.Arrays;

public class RotateArray {
    public static void rotate(int[] nums, int k){
        while(k!=0){
            int temp=nums[nums.length-1];
            for(int i=nums.length-1; i>0; i--){
                nums[i]=nums[i-1];
            }
            nums[0]=temp;
            k--;
        }
    }

    // optimized
    static void rotateRev(int [] nums, int k){
        k=k%nums.length;
        rev(nums, 0, nums.length-1);
        rev(nums, 0, k-1);
        rev(nums, k, nums.length-1);
    }

    private static void rev(int[] arr, int start, int end) {
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr={-1};
        // rotate(arr, 3);
        rotateRev(arr, 2);
        System.out.println(Arrays.toString(arr));
    }
}
