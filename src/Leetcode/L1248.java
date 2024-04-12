package Leetcode;

public class L1248 {
    public static int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k)-helper(nums, k-1);
    }
    private static int helper(int[] nums, int k){
        if(k<0){
            return 0;
        }
        int l=0 ,r=0, odd=0, count=0;
        while(r<nums.length){
            if(nums[r]%2!=0){
                odd++;
            }
            while(odd>k){
                if(nums[l]%2!=0){
                    odd--;
                }
                l++;
            }
            if(odd<=k){
                count=count+(r-l+1);
            }
            r++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr={1,1,2,1,1};
        System.out.println(numberOfSubarrays(arr, 3));
    }
}
