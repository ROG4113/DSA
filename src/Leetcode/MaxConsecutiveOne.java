package Leetcode;

public class MaxConsecutiveOne{
    public static int longestOnes(int[] nums, int k) {
        int l=0, r=0, maxLen=0, zeroes=0;
        while(r<nums.length){
            if(nums[r]==0){
                zeroes++;
            }
            while(zeroes>k){
                if(nums[l]==0){
                    zeroes--;
                }
                l++;
            }
            if(zeroes<=k){
                maxLen=Math.max(maxLen, r-l+1);
                r++;
            }
        }
        return maxLen;
    }
    //more optimized
    public static int longestOnes1(int[] nums, int k) {
        int l=0, r=0, maxLen=0, zeroes=0;
        while(r<nums.length){
            if(nums[r]==0){
                zeroes++;
            }
            if(zeroes>k){
                if(nums[l]==0){
                    zeroes--;
                }
                l++;
            }
            if(zeroes<=k){
                maxLen=Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] arr={1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes1(arr, 2));
    }
}