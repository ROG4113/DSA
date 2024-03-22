package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IntersectionArray2 {
    public static  int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0; i<nums1.length; i++){
            map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
        }
        for(int i=0; i<nums2.length; i++){
            if(map.containsKey(nums2[i])){
                list.add(nums2[i]);
                map.put(nums2[i], map.getOrDefault(nums2[i], 0)-1);
                if(map.getOrDefault(nums2[i], 0)==0){
                    map.remove(nums2[i]);
                }
            }
        }
        int[] ans=new int[list.size()];
        int index=0;
        for (int i : list) {
            ans[index++]=i;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={1,2,2,1};
        int[] arr1={2,2};                                                                   
        System.out.println(Arrays.toString(intersect(arr, arr1)));
    }
}
