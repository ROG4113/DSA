import java.util.Arrays;

public class BubbleSort {

    static void swap(int arr[], int first, int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;

    }

    public static void bubble(int arr[]){
        boolean swapped=false;
        int n = arr.length;
        for(int i=0; i<n; i++){
            //for each step(i), maximum element will be sorted to the end
            for(int j=1; j<n-i; j++){
                if(arr[j]<arr[j-1]){
                    //swap
                    swap(arr, j, j-1);
                    swapped=true;
                }
            }
            //if you did not swapped for a particular i then stop the code
            if(!swapped){
                System.out.println("Already sorted:");
                break;
            }
        }

        // for(int i=0; i<n; i++){
        //     System.out.print(arr[i]+ " ");
        // }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int array[]={5, 1, 3, 2, 4};
        // int array[]={1, 2, 3, 4, 5};
        bubble(array);
    }
}
