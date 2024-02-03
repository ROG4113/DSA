package Recursion.Recursion3;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch {
    static int search(int[] arr, int target){
        return helper(arr, target, 0);
    }
    private static int helper(int[] arr, int target, int i) {
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==target){
            return i;
        }
        return helper(arr, target, i+1);
    }
    //All occurences:
    //List outside the arguements and body

    static ArrayList<Integer> ans=new ArrayList<>();
    static ArrayList<Integer> MultipleSearch(int[] arr, int target){
        return helper1(arr, target, 0);
    }
    private static ArrayList<Integer> helper1(int[] arr, int target, int i) {
        if(i==arr.length){
            return ans;
        }
        if(arr[i]==target){
            ans.add(i);
        }
        return helper1(arr, target, i+1);
    }

    //List inside the arguements
    static ArrayList<Integer> MultipleSearch1(int[] arr, int target){
        return helper1(arr, target, 0, new ArrayList<>());
    }
    private static ArrayList<Integer> helper1(int[] arr, int target, int i, ArrayList<Integer> list) {
        if(i==arr.length){
            return list;
        }
        if(arr[i]==target){
            list.add(i);
        }
        return helper1(arr, target, i+1, list);
    }
    //List inside the body of function
    static ArrayList<Integer> MultipleSearch2(int[] arr, int target){
        return helper2(arr, target, 0);
    }
    private static ArrayList<Integer> helper2(int[] arr, int target, int i){
        ArrayList<Integer> list=new ArrayList<>();
        if(i==arr.length){
            return list;
        }
        if(arr[i]==target){
            //it will contain answer for that function call only
            list.add(i);
        }
        ArrayList<Integer> previousAnswers= helper2(arr, target, i+1);
        list.addAll(previousAnswers);
        return list;

    }
    public static void main(String[] args) {
        int[] arr={3, 2, 1, 18, 18, 9};
        int target=18;
        int ans=search(arr, target);
        System.out.println(ans);
        System.out.println(MultipleSearch(arr, target));
        System.out.println(MultipleSearch1(arr, target));
        System.out.println(MultipleSearch2(arr, target));
    }
}
