package Leetcode;

import java.util.Arrays;

public class RemoveElement {
    static int Remove(int[] nums, int val){
        int n=nums.length;
        int count=0;
        for(int i=0; i<n; i++){
            if(nums[i]==val){
                for(int k=i; k<n-1; k++){
                    nums[k]=nums[k+1];
                }
                n--;
                i--;
                count++;
            }
        }

        return nums.length-count;
    }

    public static void main(String[] args) {
        int[] arr={0,1,2,2,3,0,2,4};
        int n=Remove(arr, 2);
        System.out.println(Arrays.toString(arr));
        System.out.println(n);
    }
}
