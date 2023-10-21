package OOPs.OOP4;

public class access{
    private int num;
    String name;
    int[] arr;

    public int GetNum(){
        return num;
    }

    access(int num, String name){
        this.num = num;
        this.name = name;
        this.arr = new int[num];
    }
}