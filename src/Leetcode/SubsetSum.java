package Leetcode;

import java.util.ArrayList;

public class SubsetSum{
    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        helper(0, 0, arr, list);
        return list;
    }
    private static void helper(int index, int sum, ArrayList<Integer> arr, ArrayList<Integer> list){
        if(index>=arr.size()){
            list.add(sum);
            return;
        }
        sum+=arr.get(index);
        helper(index+1, sum, arr, list);
        sum-=arr.get(index);
        helper(index+1, sum, arr, list);
    }
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(2);
        list.add(3);
        System.out.println(subsetSums(list, 2));
    }
}