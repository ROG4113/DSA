package FileHandling;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //creating a file
        try {
            File fo=new File("newFile.txt");
            fo.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //writing to new file
        try (FileWriter fw=new FileWriter("newFile.txt")){
            fw.write("सर्वधर्मान्परित्यज्य मामेकं शरणं व्रज |\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //append writing to new file
        try (FileWriter fw=new FileWriter("newFile.txt", true)){
            fw.write("अहं त्वां सर्वपापेभ्यो मोक्षयिष्यामि मा शुच: || 66||");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //reading from  new file
        try(FileReader fr=new FileReader("newFile.txt")){
            int letters=fr.read();
            while(fr.ready()){
                System.out.print((char)letters);
                letters=fr.read();
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //deleteing a file
        try {
            File fo=new File("random.txt");
            //creating random
            fo.createNewFile();
            //deleting
            if(fo.delete()){
                System.out.println(fo.getName());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
