package Leetcode;

import java.util.Arrays;

public class TwoSum2 {
    public static void twoSum(int[] numbers, int target) {
        int start=0;
        int end=reduceSearchSpace(numbers, target);
        System.out.println(end);
    }
    private static int reduceSearchSpace(int[] numbers, int target) {
        int start=0;
        int end=numbers.length-1;
        while(start<=end){
            int mid=start+(end-start);
            if(numbers[mid]>target){
                end=mid;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        int[] arr={2,7,11,15};
        // System.out.println(Arrays.toString(twoSum(arr, 9)));
        twoSum(arr, 6);
    }
}
