import java.util.Arrays;

public class introoo{
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 45, 6};
        change(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void change(int[] array){
        array[0]=99;
        array[1]=45;
    }

}