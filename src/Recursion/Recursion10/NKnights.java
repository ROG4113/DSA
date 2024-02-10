package Recursion.Recursion10;

public class NKnights {
    static void knights(boolean[][] board, int row, int col, int targets){
        if(targets==0){
            display(board);
            return;
        }
        if(row==board.length-1 && col==board.length){
            return;
        }
        if(col==board.length){
            knights(board, row+1, 0, targets);
            return;
        }
        if(isSafe(board, row, col)){
            //marking path
            board[row][col]=true;
            knights(board, row, col+1, targets-1);
            //Backtracking/Unmarking/Restoring
            board[row][col]=false;
        }
        knights(board, row, col+1, targets);
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        if(isValid(board, row-2, col+1)){
            if(board[row-2][col+1]==true){
                return false;
            }
        }
        if(isValid(board, row-2, col-1)){
            if(board[row-2][col-1]==true){
                return false;
            }
        }
        if(isValid(board, row-1, col+2)){
            if(board[row-1][col+2]==true){
                return false;
            }
        }
        if(isValid(board, row-1, col-2)){
            if(board[row-1][col-2]==true){
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(boolean[][] board, int row, int col) {
        if(row>=0 && row<board.length && col>=0 && col<board.length){
            return true;
        }
        else{
            return false;
        }
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if(element==true){
                    System.out.print("K ");
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
        knights(board, 0, 0, n);
    }
}
