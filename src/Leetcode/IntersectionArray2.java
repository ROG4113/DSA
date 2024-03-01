package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionArray2 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list1=new ArrayList<Integer>();
        ArrayList<Integer> list2=new ArrayList<Integer>();
        ArrayList<Integer> ans=new ArrayList<Integer>();
        boolean flag=false;
        for(int i:nums1){
            list1.add(i);
        }
        for(int i:nums2){
            list2.add(i);
        }
        while(list1.size()!=0 && list2.size()!=0){
            for(int i=0; i<list2.size(); i++){
                if(list1.get(0)==list2.get(i)){
                    ans.add(list2.get(i));
                    list1.remove(0);
                    list2.remove(i);
                    flag=true;
                    break;
                }
            }
            if(!flag){
            list1.remove(0);
            }
            flag=false;
        }
        int[] arr=new int[ans.size()];
        int index=0;
        for (int i : ans) {
            arr[index++]=i;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr={1,2,2,1};
        int[] arr1={2};                                                                        
        System.out.println(Arrays.toString(intersect(arr, arr1)));
    }
}
