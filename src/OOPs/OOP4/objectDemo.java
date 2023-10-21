package OOPs.OOP4;

public class objectDemo{

    int num;

    objectDemo(int num){
        this.num = num;
    }

    @Override
    public int hashCode(){ // will go in details in hashmaps lecture.
        return super.hashCode();
    }
    @Override
    public boolean equals(Object obj){
        return super.equals(obj);
    }
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    // Already covered these two:
    @Override
    public String toString(){ // gives the string representation
        return super.toString();
    }
    @Override
    protected void finalize() throws Throwable{ // hits when garabage collector works
        super.finalize();
    }
    
}