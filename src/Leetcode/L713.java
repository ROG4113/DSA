package Leetcode;

public class L713 {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        int l=0, r=0, count=0, product=1;
        while(r<nums.length){
            product=product*nums[r];
            while(product>=k){
                product=product/nums[l];
                l++;
            }
            if(product<k){
                count=count+r-l+1;
            }
            r++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr={10,9,10,4,3,8,3,3,6,2,10,10,9,3};
        System.out.println(numSubarrayProductLessThanK(arr, 19));
    }
}
