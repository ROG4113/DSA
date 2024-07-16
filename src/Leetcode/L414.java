package Leetcode;

public class L414 {
    public static int thirdMax(int[] nums) {
        long max=Long.MIN_VALUE, secMax=Long.MIN_VALUE, thirdMax=Long.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>max){
                thirdMax=secMax;
                secMax=max;
                max=nums[i];
            }
            else if(nums[i]<max && nums[i]>secMax){
                thirdMax=secMax;
                secMax=nums[i];
            }
            else if(nums[i]<secMax && nums[i]>thirdMax) thirdMax=nums[i];
        }
        return (int)(thirdMax==Long.MIN_VALUE? max:thirdMax);
    }

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{1,-2147483648}));
    }
}
