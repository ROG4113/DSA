package Hashing;

public class Main {
    public static void main(String[] args) {
        MapUsingHash map=new MapUsingHash();
        map.put("Mango", "King of fruits");
        map.put("Apple", "Aniket's favorite fruit");
        map.put("Lychee", "A sweet fruit");
        System.out.println(map.get("Apple"));
    }
}
