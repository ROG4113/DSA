public class MathsForDSA {
    static boolean isEven(int n){
        return (n&1)==0;
    }

    static int unique(int[] arr){
        int unique=0;
        for(int n:arr){
            unique^=n;
        }
        return unique;
    }

    public static void main(String[] args) {
        // System.out.println(isEven(98));
        int[]arr={3, 4, 3, 6, 4};
        System.out.println(unique(arr));
    }
}
