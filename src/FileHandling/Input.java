package FileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    public static void main(String[] args) {
        try(InputStreamReader isr=new InputStreamReader(System.in)){
            System.out.println("Enter some letters: ");
            int letters=isr.read();
            while(isr.ready()){
                System.out.print((char)letters);
                letters=isr.read();
            }
            System.out.println();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        // reading from file
        try(FileReader fr=new FileReader("note.txt")){
            int letters=fr.read();
            while(fr.ready()){
                System.out.println((char)letters);
                letters=fr.read();
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //byte to char stream and then reading char stream
        try (BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("you typed: " + br.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (BufferedReader br=new BufferedReader(new FileReader("note1.txt"))){
            while(br.ready()){
                br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
