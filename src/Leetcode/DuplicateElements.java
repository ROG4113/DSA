package Leetcode;

import java.util.Arrays;

public class DuplicateElements {
    static int duplicate(int[] nums){
        int n=nums.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(nums[i]==nums[j]){
                    for(int k=j; k<n-1; k++){
                        nums[k]=nums[k+1];
                    }
                    n--;
                    j--;
                }
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] arr={0,0,1,1,1,2,2,3,3,4};
        int size=duplicate(arr);
        System.out.println(size);
        System.out.println(Arrays.toString(arr));
        for(int i=0; i<size; i++){
            System.out.print(arr[i]);
        }
    }
}
