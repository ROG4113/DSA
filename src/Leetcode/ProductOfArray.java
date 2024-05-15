package Leetcode;

import java.util.Arrays;

public class ProductOfArray {
    // public static int[] productExceptSelf(int[] nums) {
    //     int[] ans=new int[nums.length];
    //     int product=1;
    //     for (int i=0; i<nums.length; i++) {
    //         for (int j = 0; j < nums.length; j++) {
    //             if(j!=i){
    //                 product*=nums[j];
    //             }
    //         }
    //         ans[i]=product;
    //         product=1;
    //     }
    //     return ans;
    // }
    // //O(n)
    // public static int[] productExceptSelf1(int[] nums){
    //     int[] ans=new int[nums.length];
    //     int product=1;
    //     for (int i = 0; i < ans.length; i++) {
    //         if(nums[i]!=0){
    //             product*=nums[i];
    //         }
    //     }
    //     for (int i = 0; i < ans.length; i++) {
    //         if(nums[i]==0){
    //             ans[i]=product;
    //         }else{
    //             ans[i]=product/nums[i];
    //         }
    //     }
    //     return ans;
    // }
    //USING PREFIX(OPTIMAL)
    public static int[] productExceptSelf(int[] nums) {
        int[] pref=new int[nums.length];
        int[] suf=new int[nums.length];
        int lProduct=1, rProduct=1;
        for(int i=0; i<nums.length; i++){
            pref[i]=lProduct;
            lProduct=lProduct*nums[i];
            suf[nums.length-1-i]=rProduct;
            rProduct=rProduct*nums[nums.length-1-i];
        }
        for(int i=0; i<nums.length; i++){
            nums[i]=suf[i]*pref[i];
        }
        return nums;
    }
    public static void main(String[] args) {
        int[]arr={1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }
} 
