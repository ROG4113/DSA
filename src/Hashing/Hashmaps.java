package Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class Hashmaps {
    public static void main(String[] args) {
        HashMap<String, Integer> map=new HashMap<String, Integer> ();
        map.put("Aniket", 86);
        map.put("Anshika", 94);
        map.put("Chaitanya", 99);
        System.out.println(map.get("Aniket"));
        System.out.println(map.entrySet());
        HashSet<Integer> set=new HashSet<>();
        set.add(56);
        set.add(56);
        set.add(84);
        set.add(54);
        set.add(84);
        System.out.println(set);
    }
}
