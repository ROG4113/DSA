package Leetcode;

import java.util.Arrays;

public class L2574 {
    public static int[] leftRightDifference(int[] nums) {
        int[] ans=new int[nums.length];
        int[] pref=new int[nums.length];
        int[] suf=new int[nums.length];
        int lSum=0, rSum=0;
        for(int i=0; i<nums.length; i++){
            pref[i]=lSum;
            lSum=lSum+nums[i];
            suf[nums.length-1-i]=rSum;
            rSum=rSum+nums[nums.length-1-i];
        }
        for(int i=0; i<nums.length; i++){
            ans[i]=Math.abs(pref[i]-suf[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={10, 4, 8, 3};
        System.out.println(Arrays.toString(leftRightDifference(arr)));
    }
}
