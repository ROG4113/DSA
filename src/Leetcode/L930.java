package Leetcode;

public class L930 {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return ahhhhhh(nums, goal)-ahhhhhh(nums, goal-1);
    }
    private static int ahhhhhh(int[] nums, int goal){
        if(goal<0){
            return 0;
        }
        int l=0, r=0, count=0, sum=0;
        while(r<nums.length){
            if(nums[r]==1){
                sum++;
            }
            while(sum>goal){
                if(nums[l]==1){
                    sum--;
                }
                l++;
            }
            if(sum<=goal){
                count=count+(r-l+1);
            }
            r++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] binary={1, 0, 1, 0, 1};
        System.out.println(numSubarraysWithSum(binary, 2));
    }
}
