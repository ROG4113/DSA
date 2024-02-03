import java.util.Arrays;


public class SelectionSort {
    static void swap(int arr[], int first, int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }

    static void selection(int[] arr){
        int n=arr.length;
        for(int i=0; i<n; i++){
            int lastindex=n-i-1;
            int maxindex = maxindex(arr,0 , lastindex);
            swap(arr, maxindex, lastindex);
        }
        System.out.println(Arrays.toString(arr));
    }

    static int maxindex(int[] arr, int start, int end){
        int max=start;
        for(int i=start; i<=end; i++){
            if(arr[max]<arr[i]){
                max=i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array={5, 2, 4, 1, 3};
        selection(array);
    }
}
