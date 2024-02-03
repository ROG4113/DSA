package Leetcode;

import java.util.Arrays;

public class SmallerThanCurrent{
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr=new int[nums.length];
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0 ; j < nums.length; j++) {
                if(nums[i]>nums[j]){
                    count++;
                }
            }
            arr[i]=count;
            count=0;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr={8,1,2,2,3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(arr)));
    }
}
