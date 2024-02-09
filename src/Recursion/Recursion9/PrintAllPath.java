package Recursion.Recursion9;

import java.util.Arrays;

public class PrintAllPath {
    static void printpath(String p, boolean[][] maze, int r, int c, int[][] path, int step){
        if(r==path.length-1 && c==path[0].length-1){
            path[r][c]=step;
            for (int[] i : path) {
                System.out.println(Arrays.toString(i));
            }
            System.out.println(p);
            // System.out.println();
            return;
        }
        if(maze[r][c]==false){
            return;
        }
        maze[r][c]=false;//marking
        path[r][c]=step;//saving path 
        if(r>0){
            printpath(p+"U", maze, r-1, c, path, step+1);
        }
        if(c>0){
            printpath(p, maze, r, c-1, path, step+1);
        }
        if(r<path.length-1){
            printpath(p+"D", maze, r+1, c, path, step+1);
        }
        if(c<path[0].length-1){
            printpath(p+"R", maze, r, c+1, path, step+1);
        }
        maze[r][c]=true;//restoring
        path[r][c]=0;//restoring
    }
    public static void main(String[] args) {
        boolean[][] arr={
            {true, true, true},
            {true, true, true},
            {true, true, true}
        };
        int[][] path={
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        printpath("", arr, 0, 0, path, 1);
    }
}
