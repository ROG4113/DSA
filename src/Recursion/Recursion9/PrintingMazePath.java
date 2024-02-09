package Recursion.Recursion9;

public class PrintingMazePath {
    static void printinPath(String p, int r, int c){
        if(r==1&&c==1){
            System.out.println(p);
            return;
        }
        if(r!=1){
            printinPath(p+"D", r-1, c);
        }
        if(c!=1){
            printinPath(p+"R", r, c-1);
        }
        return;
    }
    //Including diagonal moves
    static void printinPath1(String p, int r, int c){
        if(r==1&&c==1){
            System.out.println(p);
            return;
        }
        //down
        if(r!=1){
            printinPath1(p+"D", r-1, c);
        }
        //right
        if(c!=1){
            printinPath1(p+"R", r, c-1);
        }
        //diagonal
        if(r!=1&&c!=1){
            printinPath1(p+"P", r-1, c-1);
        }
        return;
    }
    public static void main(String[] args) {
        // printinPath("", 3, 3);
        printinPath1("", 3, 3);
    }
}
