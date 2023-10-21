package BinarySearch;
public class binary_search{
    public static void main(String[] args) {
        // int[] array={1,2,3,4,5,6,7,8,9,10};
        int[] array={10,9,8,7,6,5,4,3,2,1};
        //int[] array={5,5,5,5,5,5,5,5,5,5,5,5,5,5,5};
        int target = 5;
        int ans = BinarySearch(array, target);
        System.out.println(ans);
    }

    static int BinarySearch(int[] arr, int target){

        int start=0;
        int end = arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(arr[end]>arr[start]){
                if(target>arr[mid]){
                start=mid+1;
                }
                else{
                end=mid-1;
                }
            }else{
                if(target>arr[mid]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
        }
        return -1;
    }
}