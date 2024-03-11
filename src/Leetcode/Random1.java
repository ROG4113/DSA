package Leetcode;

import java.util.Arrays;

public class Random1 {
    public static void moveZeroes(int[] nums) {
        int nonzero=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                int temp=nums[i];
                nums[i]=nums[nonzero];
                nums[nonzero]=temp;
                nonzero++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr={1};
        moveZeroes(arr);
    }
}
