package Leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class MaxPairs {
    public static int[] numberOfPairs(int[] nums) {
        HashSet<Integer> set=new HashSet<Integer>();
        int count=0;
        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
                count++;
            }
            else set.add(nums[i]);
        }
        return new int[] {count, set.size()};
    }
    public static void main(String[] args) {
        int[] arr={1,1};
        System.out.println(Arrays.toString(numberOfPairs(arr)));
    }
}
