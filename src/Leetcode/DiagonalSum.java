package Leetcode;

public class DiagonalSum {
    public static int diagonalSum(int[][] mat) {
        int sum=0;
        int n=mat[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j || i+j==n-1){
                    sum+=mat[i][j];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int [][] arr={{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        System.out.println(diagonalSum(arr));
    }
}
