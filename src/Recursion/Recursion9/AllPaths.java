package Recursion.Recursion9;

import java.util.Arrays;

public class AllPaths {
    static void AllPathPossible(String p, int r, int c, boolean[][] maze){
        if(r==maze.length-1&&c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(maze[r][c]==false){
            return;
        }
        //Considering this block in the path so making it false
        maze[r][c]=false;//marking path false while moving
        

        //down
        if(r<maze.length-1){
            AllPathPossible(p+"D", r+1, c, maze);
        }
        //right
        if(c<maze[0].length-1){
            AllPathPossible(p+"R", r, c+1, maze);
        }
        //up
        if(r>0){
            AllPathPossible(p+"U", r-1, c, maze);
        }
        //left
        if(c>0){
            AllPathPossible(p+"L", r, c-1, maze);
        }
        //this line is where the function will be over
        //so before the function gets removed also remove the change made by that function 
        maze[r][c]=true;//restoring path while returning
    }

    public static void main(String[] args) {
        boolean[][] arr={
            {true, true, true},
            {true, true, true},
            {true, true, true}
        };
        AllPathPossible("", 0, 0, arr);
    }
}
