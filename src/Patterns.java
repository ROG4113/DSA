public class Patterns {
    static void pattern1(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern2(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern3(int n){
        for(int i=0; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern4(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    static void pattern5(int n){
        for(int i=1; i<=2*n-1; i++){
            if(i<n){
                for(int j=1; j<=i; j++){
                    System.out.print("* ");
                }
            }
            else{
                for(int j=1; j<=n-(i-n); j++){
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
    static void pattern28(int n){
        for(int i=1; i<=2*n-1; i++){
            int ColumnsForRow=i<n?i:n-(i-n);
            int spaces=n-ColumnsForRow;
            for(int k=1; k<=spaces; k++){
                System.out.print(" ");                                                                                                                                                                  
            }
            
            for(int j=1; j<=ColumnsForRow; j++){
                    System.out.print("* ");
                }
            System.out.println();
        }
    }
    static void pattern30(int n){
        for(int i=1; i<=n; i++){
            for(int s=1; s<=(n-i); s++){
                System.out.print(" ");      
            }
            for(int j=i; j>1; j--){
                System.out.print(j);
            }
            for(int k=1; k<=i; k++){
                System.out.print(k);
            }
            System.out.println();
        }
    }
    static void pattern17(int n){
        for(int i=1; i<=2*n; i++){
            int col=i<n?i:n-(i-n);
            int spaces=n-col;
            for(int s=1; s<=spaces; s++){
                System.out.print(" ");
            }
            for(int j=col; j>1; j--){
                System.out.print(j);
            }
            for(int k=1; k<=col; k++){
                System.out.print(k);
            }
            System.out.println();
        }
    }
    static void pattern31(int n){
        int originalN=n;
        n=2*n;
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                //Distance from:
                //Left=col, Right=N-col, Up=row, Down=N-row
                int valueAtEveryIndex=originalN-Math.min(Math.min(i, j), Math.min(n-i, n-j));
                System.out.print(valueAtEveryIndex + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // pattern1(5);
        // pattern2(5);
        // pattern3(5);
        // pattern4(5);
        // pattern5(5);
        // pattern28(5);
        // pattern30(5);
        pattern17(5);
        // pattern31(4);
    }
}
