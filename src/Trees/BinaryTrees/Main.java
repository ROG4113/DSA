package Trees.BinaryTrees;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BinaryTrees tree=new BinaryTrees();
        tree.populate(sc);
        // tree.display();15
        tree.prettyDisplay();
    }
}
