package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountMatches{
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count=0;
        for (List<String> list : items) {
            
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<List<String>> group = new ArrayList<List<String>>();
        group.add(Arrays.asList("phone","blue","pixel"));
        group.add(Arrays.asList("computer","silver","lenovo"));
        group.add(Arrays.asList("phone","gold","iphone"));

        int ans=countMatches(group, "color", "silver");
        System.out.println(ans);
    }
}
