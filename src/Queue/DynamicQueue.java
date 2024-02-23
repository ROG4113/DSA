package Queue;

public class DynamicQueue extends CircularQueue{
    //constructor
    protected DynamicQueue(){
        super();
    }
    protected DynamicQueue(int size){
        super(size);
    }
    @Override
    public boolean insert(int value){
        if(isFull()){
            int[] temp=new int[data.length*2];
            for (int i = 0; i < data.length; i++) {
                temp[i]=data[(front+i)%data.length];
            }
            data=temp;
            front=0;
            end=data.length;
        }
        return super.insert(value);
    }
}
