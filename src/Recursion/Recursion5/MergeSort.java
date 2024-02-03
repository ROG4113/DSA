package Recursion.Recursion5;

import java.util.Arrays;

public class MergeSort {
    static int[] sort(int[] arr){
        if(arr.length==1){
            return arr;
        }
        int mid=arr.length/2;
        int[] left=sort(Arrays.copyOfRange(arr, 0, mid));
        int[] right=sort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);

    }

    private static int[] merge(int[] left, int[] right){
        int[] ans=new int[left.length+right.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<left.length&&j<right.length){
            if(left[i]<right[j]){
                ans[k]=left[i];
                i++;
            }
            else{
                ans[k]=right[j];
                j++;
            }
            k++;
        }
        while(i<left.length){
            ans[k]=left[i];
            i++;
            k++;
        }
        while(j<right.length){
            ans[k]=right[j];
            j++;
            k++;
        }
        return ans;
    }

    //sorting without creating new array
    static void sortInPlace(int[] arr, int s, int e){
        if(e-s==1){
            return;
        }
        int mid=(s+e)/2;
        sortInPlace(arr, s, mid);
        sortInPlace(arr, mid, e);
        mergeInPlace(arr, s, mid, e);

    }
    private static void mergeInPlace(int[] arr, int s, int m, int e){
        int[] ans=new int[e-s];
        int i=s;
        int j=m;
        int k=0;
        while(i<m&&j<e){
            if(arr[i]<arr[j]){
                ans[k]=arr[i];
                i++;
            }
            else{
                ans[k]=arr[j];
                j++;
            }
            k++;
        }
        while(i<m){
            ans[k]=arr[i];
            i++;
            k++;
        }
        while(j<e){
            ans[k]=arr[j];
            j++;
            k++;
        }
        for (int l = 0; l < ans.length; l++) {
            arr[s+l]=ans[l];
        }
    }

    public static void main(String[] args) {
        int[] arr={5, 4, 3, 2, 1};
        int[] arr2={5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(sort(arr)));
        sortInPlace(arr2, 0, arr.length);
        System.out.println(Arrays.toString(arr2));
    }
}
