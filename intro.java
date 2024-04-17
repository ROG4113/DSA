import java.util.Scanner;
public class intro{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int a = 0;
        int b = 1;
        int count = 2;

        for(int i=0; i<=n; i++){
            int temp = b;
            b=b+a;
            a = temp;
            count++;
        }
        System.out.println(b);
        sc.close();
    }
}