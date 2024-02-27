package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfArray {
    public static int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            int target=nums1[i];
            if(!list.contains(target)){
                for (int j = 0; j < nums2.length; j++) {
                    if(target==nums2[j]){
                        list.add(nums2[j]);
                        break;
                    }
                }
            }
        }
        int[] ans=new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i]=list.get(0);
            list.remove(0);
        }
        return ans;
    }
    //optimized
    public static int[] intersectionOP(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<Integer>();
        HashSet<Integer> intersection=new HashSet<Integer>();
        for(int i=0; i<nums1.length; i++){
            set.add(nums1[i]);
        }
        for(int i=0; i<nums2.length; i++){
            if(set.contains(nums2[i])){
                intersection.add(nums2[i]);
            }
        }
        int[] ans=new int[intersection.size()];
        int index=0;
        for (int i : intersection) {
            ans[index++]=i;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={4,9,5,4};
        int[] arr1={9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(arr, arr1)));
        System.out.println(Arrays.toString(intersectionOP(arr, arr1)));
    }
}
