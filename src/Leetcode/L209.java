package Leetcode;

public class L209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int l=0, r=0, sum=0, length=0, min=Integer.MAX_VALUE;
        while(r<nums.length){
            sum=sum+nums[r++];
            while(sum>=target){
                length=r-l;
                min=Math.min(min, length);
                sum=sum-nums[l++];
            }
        }
        if(min==Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }
    public static void main(String[] args) {
        int[] arr={1, 2, 3, 4, 5};
        System.out.println(minSubArrayLen(11, arr));
    }
}
