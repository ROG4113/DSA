package Leetcode;

import java.util.Arrays;

public class FlippingAnImage {
    static int[][] flip(int[][]image){
        for(int[] row: image){
            //swap
            for(int i=0; i<(image[0].length+1)/2;i++){
                int temp=row[i]^1;
                row[i]=row[image[0].length-1-i]^1;
                row[image[0].length-1-i]=temp;
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][]arr={{1,1,0},{1,0,1},{0,0,0}};
        System.out.println(Arrays.toString(arr));
    }
}
