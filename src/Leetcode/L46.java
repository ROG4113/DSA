package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L46{
    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> list= new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        HashMap<Integer, Integer> map =new HashMap<>();
        helper(map, nums, list, ans);
        return ans;
    }
    private static void helper(HashMap<Integer, Integer> map, int[] arr, List<Integer> list, List<List<Integer>> ans){
        if(list.size()==arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(map.get(arr[i])==null){
                map.put(arr[i], 1);
                list.add(arr[i]);
                helper(map, arr, list, ans);
                list.remove(list.size()-1);
                map.put(arr[i], null);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}