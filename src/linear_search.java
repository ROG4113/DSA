public class linear_search {
    public static void main(String[] args) {
        int[] array={32, 46, 74, 94, 95, 56, 96, 36, 6, 2, 9, 56};
        int ans=LinearSearch(array, 9);
        System.out.println(ans);
    }

    static int LinearSearch(int[] arr, int target){
        if(arr.length==0){
            return -1;
        }

        for(int index=0; index<arr.length; index++){
            if(arr[index]==target){
                return index;
            }
        }
        return -1;
    }
}