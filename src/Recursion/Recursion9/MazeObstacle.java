package Recursion.Recursion9;

public class MazeObstacle {
    static void mazeObstacles(String p, int r, int c, boolean[][] maze){
        if(r==maze.length-1&&c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(maze[r][c]==false){
            return;
        }
        //down
        if(r<maze.length-1){
            mazeObstacles(p+"D", r+1, c, maze);
        }
        //right
        if(c<maze[0].length-1){
            mazeObstacles(p+"R", r, c+1, maze);
        }
    }

    public static void main(String[] args) {
        boolean[][] arr={
            {true, true, true},
            {true, false, true},
            {true, true, true}
        };
        mazeObstacles("", 0, 0, arr);
    }
}
