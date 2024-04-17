import java.util.Scanner;

public class introo {
    public static void sum(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        int sum = a+b;
        System.out.println(sum);
    }
    // returning the value
    public static int sum2(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        int sum = a+b;
        return sum;
    }
    // passing the value 

    public static int sum3(int a, int b ){
        return a+b;
    }
    //String parameters
    public static String name(String x, String y, String z){
        return "First name: "+x+"\nMiddle name: "+y+"\nLast name: "+z;
    }    
    public static void main(String[] args) {
        //sum();
        //System.out.println(sum2());
        //System.out.println(sum3(55, 45));
        //String name = name("First", "Mid", "Last")
        //System.out.println(name);
    }
    
}