package FileHandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Output {
    public static void main(String[] args) {
        //output
        System.out.println();
        try(OutputStreamWriter osw=new OutputStreamWriter(System.out)) {
            osw.write("Hello");
            osw.write(97);
            osw.write(10);
            osw.write('A');
            osw.write('\n');
            char[] arr="hello world".toCharArray();
            osw.write(arr);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //writing
        try (FileWriter fw=new FileWriter("note.txt")){
            fw.write("hello");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //writing appended
        try (FileWriter fw=new FileWriter("note.txt", true)){
            fw.write(" this should be appended");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //buffered writing
        try (BufferedWriter bw=new BufferedWriter(new FileWriter("note.txt"))){
            bw.write("Hare Krishna");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
