package OOPs.OOP6;

public class CustomArrayList {
    private int[]data;
    private static int DEFAULT_SIZE=10;
    private int size=0;

    public CustomArrayList(){
        this.data = new int[DEFAULT_SIZE]; 
    }

    public void add(int num){
        if(isFull()){
            resize();
        }
        data[size++]=num;
    }
    private boolean isFull() {
        return size==data.length;
    }
    public void resize(){
        int[] temp = new int[data.length*2];
        for(int i=0; i<=data.length; i++){
            temp[i]=data[i];
        }
        data=temp;
    }
}
