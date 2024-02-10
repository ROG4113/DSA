package Recursion.Recursion10.Backtracking;

public class NQueens {
    static int queens(boolean[][] board, int row){
        if(row==board.length){
            display(board);
            return  1;
        }
        int count=0;//counting the number of ways
        //placing the queen and checking for every row and column
        for (int col = 0; col < board.length; col++) {
            //if safe place the queen
            if(isSafe(board, row, col)){
                board[row][col]=true;//mark path
                count+=queens(board, row+1);
                board[row][col]=false;//backtracking
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        //checking vertical row
        for (int i = 0; i < row; i++) {
            if(board[i][col]){
                return false;
            }
        }
        //checking diagonal left up
        int maxDiagonalL=Math.min(row, col);
        for (int i = 1; i <= maxDiagonalL; i++) {
            if(board[row-i][col-i]==true){
                return false;
            }
        }
        //checking diagonal right up
        int rightCol=board[0].length-col-1;
        int maxDiagonalR=Math.min(row, rightCol);
        for (int i = 1; i <= maxDiagonalR; i++) {
            if(board[row-i][col+i]==true){
                return false;
            }
        }
        //if none of the condition return false just return true
        return true;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if(element==true){
                    System.out.print("Q ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int n=4;
        boolean[][] board=new boolean[n][n];
        System.out.println(queens(board, 0));
    }
}
