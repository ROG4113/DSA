import java.util.Arrays;

public class CyclicSort {
    static void cyclic(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i]-1;
            if(arr[i]>0 && arr[i]!=arr[correct] && arr[i]<arr.length){
                swap(arr, i, correct);
            }
            else{
                i++;
            }
        }
    }

    static void swap(int[] arr, int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public static void main(String[] args){
        int[] nums={7, 5, 1, 3, -1};
        cyclic(nums);
        System.out.println(Arrays.toString(nums));
    }
}
