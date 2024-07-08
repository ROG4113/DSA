package Leetcode;

import java.util.LinkedList;
import java.util.List;

public class L1823 {
    public static int findTheWinner(int n, int k){
        int index=0;
        List<Integer> list=new LinkedList<>();
        for(int i=1; i<=n; ++i) list.add(i);
        while(list.size()>1){
            int remove=(index+k-1)%list.size();
            list.remove(remove);
            index=remove;
        }
        return list.get(0);
    }    
    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2));
    }
}
