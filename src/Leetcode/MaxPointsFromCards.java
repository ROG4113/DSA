package Leetcode;

public class MaxPointsFromCards{
    public static int MaxPoints(int[] nums, int k){
        int lsum=nums[0], rsum=0, maxsum=0;
        for(int i=1; i<k; i++){
            lsum+=nums[i];
        }
        maxsum=lsum;
        int r=nums.length-1;
        for(int i=k-1; i>=0; i--){
            lsum-=nums[i];
            rsum+=nums[r--];
            maxsum=Math.max(maxsum, lsum+rsum);
        }
        return maxsum;
    }
    public static void main(String[] args) {
        int[] arr={6,2,3,4,7,2,1,7,1};
        System.out.println(MaxPoints(arr, 4));
    }
}