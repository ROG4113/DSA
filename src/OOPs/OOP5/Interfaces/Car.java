package OOPs.OOP5.Interfaces;

public class Car implements Engine, Brake, Media{
    @Override
    public void start(){
        System.out.println("I start engine like a normal car");
    }
    @Override
    public void stop(){
        System.out.println("I stop engine like a normal car");
    }
    @Override
    public void acc(){
        System.out.println("I acc like a normal car");
    }
    @Override
    public void brake(){
        System.out.println("I brake like a normal car"); 
    }
    // @Override
    // public void start(){
    //     System.out.println("I start media like a normal car"); 
    // }
    // @Override
    // public void stop(){
    //     System.out.println("I stop media like a normal car"); 
    // }
}