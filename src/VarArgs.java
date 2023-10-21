import java.util.Arrays;

public class VarArgs{
    public static void main(String[] args){
        greet("Aniket", "Singh");
        greet("Aniket", "Singh", "Singh2");
        printnum(3, 7, 4, 8, 4, 8, 5, 7);
        printstrings("aniket", "chaitanya", "anshika");
    }

    
    static void greet(String a, String b){
        System.out.println("First name: "+a+"\nLast name: "+b);
    }

    static void gret(String a, String b, String c){
        System.out.println("First name: "+a+"\nMiddle name: "+b+"\nLast name: "+c);
    }

    static void printnum(int ...VarArgs){
        System.out.println(Arrays.toString(VarArgs));
    }

    static void printstrings(String ...VarArgs){
        System.out.println(Arrays.toString(VarArgs));
    }
}