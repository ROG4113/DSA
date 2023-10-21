package OOPs;

public class OOP2 {
    public static void main(String[] args) {
        Student chait1 = new Student("Chait1", 12, 89.2f);
        Student chait2 = new Student("Chait2", 29, 99.2f);
        Student chait3 = new Student("Chait3", 32, 79.2f);
        
        System.out.println(chait1.HumanPopulation);
        System.out.println(chait2.HumanPopulation);
        System.out.println(chait3.HumanPopulation);
    }
    
    void fun(){
        System.out.println("have fun!");
    }
    static void fun2(){
        System.out.println("have fun2!");
    }
    void enjoy(){
        fun();
    }
    static void enjoy2(){
        fun2();
    }
    void enjoy3(){
        fun2();
    }
    // void enjoy3(){
    //     fun2();
    // }
}