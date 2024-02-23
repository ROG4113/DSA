package Stack;

public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE=10;
    int ptr=-1;
    //method to push
    public boolean push(int item){
        if(isFull()){
            System.out.println("Stack is full");
            return false;
        }
        ptr++;
        data[ptr]=item;
        return true;
    }
    //method to pop an item
    public int pop() throws CustomException{
        if(isEmpty()){
            throw new CustomException("Stack is empty");
        }
        // int removed=data[ptr];
        // ptr--;
        // return removed;
        return data[ptr--];
    }
    //method to peek
    public int peek() throws CustomException{
        if(isEmpty()){
            throw  new CustomException("Stack is empty");
        }
        return data[ptr];
    }
    protected boolean isFull() {
        if(ptr==data.length-1){
            return true;
        }
        else return false;
    }
    private boolean isEmpty(){
        if(ptr==-1){
            return true;
        }
        else return false;
    }
    //constructor
    protected CustomStack(){
        this(DEFAULT_SIZE);
    }
    protected CustomStack(int size){
        this.data=new int[size];
    }
}
