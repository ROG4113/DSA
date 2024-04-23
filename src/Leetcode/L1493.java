package Leetcode;

public class L1493 {
    public static int longestSubarray(int[] nums) {
        int l=0, r=0, zero=0, max=0;
        while(r<nums.length){
            if(nums[r]==0){
                zero++;
            }
            if(zero>1){
                if(nums[l++]==0) zero--;
            }
            if(zero<=1){
                max=Math.max(max, r-l+1);
            }
            r++;
        }
        return max-1;
    }
    public static void main(String[] args) {
        int[] arr={0,1,1,1,0,1,1,0,1};
        System.out.println(longestSubarray(arr));
    }
}
