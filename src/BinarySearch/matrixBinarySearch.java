package BinarySearch;
import java.util.Arrays;

public class matrixBinarySearch {
    public static void main(String[] args) {
        int arr[][]= {
            {10, 20, 30},
            {19, 29, 38},
            {28, 31, 39},
            {36, 49, 47}
        };
        int target=50;
        System.out.println(Arrays.toString(search(arr, target)));
    }
    //For 
    static int[] search(int arr[][], int target){
        System.out.println(arr.length);
        System.out.println(arr[0].length);
        int r=0;
        int c=arr.length-1;
        while(r<=arr.length-1 && c>=0){
            if(arr[r][c]==target){
                return new int[] {r,c};
            }
            else if(arr[r][c]<target){
                r++;
            }
            else{
                c--;
            }
        }
        return new int[] {-1, -1};
    }
}
