package Queue;

public class CustomQueue {
    private int[] data;
    private static final int DEFAULT_SIZE=10;
    int end=0;
    //method to insert
    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        data[end++]=item;
        return true;
    }
    //method to remove
    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        int removed=data[0];
        for (int i = 0; i < end-1; i++) {
            data[i]=data[i+1];
        }
        end--;
        return removed;
    }
    //method to peek front
    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        return data[0];
    }
    //method to display queue
    public void display(){
        if(end<0){
            return;
        }
        for (int i = 0; i < end; i++) {
            System.out.print(data[i]+" ");
        }
        System.out.println("END");
    }
    private boolean isFull() {
        if(end==data.length){
            return true;
        }
        else return false;
    }
    private boolean isEmpty(){
        if(end==0){
            return true;
        }
        else return false;
    }
    //constructor
    protected CustomQueue(){
        this(DEFAULT_SIZE);
    }
    protected CustomQueue(int size){
        this.data=new int[size];
    }
}
