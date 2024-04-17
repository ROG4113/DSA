import java.util.Arrays;
import java.util.Scanner;
public class arrays{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        //initializing a 2d array
        int [] [] arr = new int [3][3];

        //taking input
        for(int row=0; row<3; row++){
            for(int col=0; col<arr[row].length;col ++){
                arr[row][col]=in.nextInt();
            }
        }

        //output

        for(int row=0; row<3; row++){
            for(int col=0; col<arr[row].length; col++){
                System.out.print(arr[row][col]+ " ");
            }
            System.out.println();
        }

        for(int row=0; row<arr.length; row++){
            System.out.println(Arrays.toString(arr[row]));
        }
    
    }
}