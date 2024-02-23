package Queue;

public class CircularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE=10;
    protected int front=0;
    protected int end=0;
    protected int size=0;
    //method to insert
    public boolean insert(int item){
        if(isFull()){
            System.out.println("Circualr queue is full");
            return false;
        }
        data[end++]=item;
        end=end%data.length;
        size++;
        return true;
    }
    //method to remove
    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Circualr queue is empty");
        }
        int removed=data[front++];
        front=front%data.length;
        size--;
        return removed;
    }
    //method to get front
    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Circualr queue is empty");
        }
        return data[front];
    }
    //method to display queue
    public void display(){
        if(isEmpty()){
            System.out.println("Circualr queue is empty");
            return;
        }
        int i=front;
        do{
            System.out.print(data[i++] + " ");
            i=i%data.length;
        }while(i!=end);
        System.out.println("END");
    }
    protected boolean isFull() {
        if(size==data.length){
            return true;
        }
        else return false;
    }
    protected boolean isEmpty(){
        if(size==0){
            return true;
        }
        else return false;
    }
    //constructor
    protected CircularQueue(){
        this(DEFAULT_SIZE);
    }
    protected CircularQueue(int size){
        this.data=new int[size];
    }
}
