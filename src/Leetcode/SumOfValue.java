package Leetcode;

public class SumOfValue {
    public static int sumIndicesWithKSetBits(int[] nums, int k) {
        int sum=0;
        for(int i=0; i<nums.length; i++){
            if(Integer.bitCount(i)==k){
                sum+=nums[i];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] arr={5,10,1,5,2};
        System.out.println(sumIndicesWithKSetBits(arr, 1));
    }
}
