package Leetcode;

public class Robber {
    public static int rob(int[] nums) {
        int arraySize = nums.length;
        int prevSum=0;
        int currSum=0;

        if(arraySize == 1) return nums[0];

        if(arraySize == 2) return Math.max(nums[0], nums[1]);

        prevSum = nums[0];
        currSum = Math.max(nums[0], nums[1]);

        for(int i=2; i < nums.length; i++) {
            int temp = currSum;
            currSum = Math.max(prevSum + nums[i], currSum);
            prevSum = temp;
        }
        return currSum;
    }

        public static void main(String[] args) {
            int[] nums = {2,1,1,2,4,4,8};
            System.out.println(rob(nums));
        }
    }
