package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    static boolean duplicate(int[] nums){
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
    //optimized
    static boolean duplicate1(int[] nums){
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr={1, 2, 3, 4, 5, 3};
        System.out.println();
        System.out.println(duplicate(arr));
        System.out.println(duplicate1(arr));
    }
}
