package OOPs; 

class OOP1{
    public static void main(String[] args){
        
    //int[] rollno = new int[5];
    //String[] name = new String[5];
    //float[] marks = new float[5];

    //Student[] students = new Student[5];

    Student Aniket = new Student();

    System.out.println(Aniket.name);
    System.out.println(Aniket.rollno);
    System.out.println(Aniket.marks);
    System.out.println(Aniket.HumanPopulation);

    Student chait = new Student("Chaitanya Singh", 69, 95.6f);

    System.out.println(chait.name);
    System.out.println(chait.rollno);
    System.out.println(chait.marks);
    System.out.println(chait.HumanPopulation);

    }
}
class Student{

    String name;
    int rollno;
    float marks;
    static long HumanPopulation;

    Student(){
        this.name = "Aniket Singh";
        this.rollno = 32;
        this.marks = 88.6f;
        this.HumanPopulation += 1;
    }
    Student(String name, int rollno, float marks){
        this.name = name;
        this.rollno = rollno;
        this.marks = marks;
        this.HumanPopulation += 1;
    }
}