package Leetcode;

import java.util.Arrays;

public class ProductOfArray {
    public static int[] productExceptSelf(int[] nums) {
        int[] ans=new int[nums.length];
        int product=1;
        for (int i=0; i<nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(j!=i){
                    product*=nums[j];
                }
            }
            ans[i]=product;
            product=1;
        }
        return ans;
    }
    //O(n)
    public static int[] productExceptSelf1(int[] nums){
        int[] ans=new int[nums.length];
        int product=1;
        for (int i = 0; i < ans.length; i++) {
            if(nums[i]!=0){
                product*=nums[i];
            }
        }
        for (int i = 0; i < ans.length; i++) {
            if(nums[i]==0){
                ans[i]=product;
            }else{
                ans[i]=product/nums[i];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[]arr={-1,1,-3,-3,3};
               //[-9,9,9,-3,3] {2, 3, 0, 2, 0}
        System.out.println(Arrays.toString(productExceptSelf1(arr)));
    }
} 
