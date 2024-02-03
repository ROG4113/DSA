package Recursion.Recursion3;

public class Sorted{
    static boolean sort(int[] arr){
        return helper(arr, 0);
    }
    private static boolean helper(int[] arr, int n){
        if(n==arr.length-1){
            return true;
        }
        if(arr[n]<arr[n+1]){
            return helper(arr, n+1);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr={1, 2, 4, 8, 9, 12};
        boolean ans=sort(arr);
        System.out.println(ans);

    }
}