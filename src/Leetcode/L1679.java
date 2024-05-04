package Leetcode;

import java.util.Arrays;

public class L1679{
    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int  l=0, r=nums.length-1, count=0;
        while(l<r){
            if(nums[l]+nums[r]==k){
                l++;
                r--;
                count++;
            }
            else if(nums[l]+nums[r]<k){
                l++;
            }
            else r--;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr={2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2};
        System.out.println(maxOperations(arr, 3));
    }
}