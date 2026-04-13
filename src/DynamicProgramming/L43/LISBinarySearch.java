package DynamicProgramming.L43;

import java.util.ArrayList;
import java.util.List;

public class LISBinarySearch {

    public static int lis(int[] nums){
        List<Integer> list=new ArrayList<>();
        for(int i:nums){
            if(list.isEmpty() || list.get(list.size()-1)<=i){
                list.add(i);
            }
            else{
                int index=insert(list, i);
                list.set(index, i);
            }
        }
        return list.size();
    }

    public static int insert(List<Integer> nums, int target){
        int l=0, r=nums.size()-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums.get(mid)>target){
                r=mid-1;
            }
            else if(nums.get(mid)<target){
                l=mid+1;
            }
            else{
                return mid;
            }
        }
        return r+1;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1, 7, 8, 4, 5, 6, -1, 9};
        System.out.println(lis(nums));
    }
}
