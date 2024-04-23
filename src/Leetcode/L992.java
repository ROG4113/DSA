package Leetcode;

import java.util.HashMap;

public class L992 {
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return count(nums, k)-count(nums, k-1);
    }
    private static int count(int[] nums, int k){
        if(k==0) return 0;
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        int r=0, l=0, count=0;
        while(r<nums.length){
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
            while(map.size()>k){
                map.put(nums[l], map.getOrDefault(nums[l], 0)-1);
                if(map.get(nums[l])<=0){
                    map.remove(nums[l]);
                }
                l++;
            }   
            if(map.size()<=k){
                count=count+r-l+1;
            }
            r++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr={1, 2, 1, 2, 3};
        System.out.println(subarraysWithKDistinct(arr, 2));
    }
}
