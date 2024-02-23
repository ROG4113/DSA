package Trees.BinaryTrees;

import java.util.Scanner;

public class BinaryTrees {
    private Node root;
    private static class Node{
        int value;
        Node left;
        Node right;
        //constructor
        public Node(int value){
            this.value=value;
        }
    }
    //insert a node
    public void populate(Scanner sc){
        System.out.println("Enter the root node: ");
        int value=sc.nextInt();
        root=new Node(value);
        populate(sc, root);
    }
    private void populate(Scanner sc, Node node) {
        System.out.println("Do you want to enter at the left of " + node.value);
        boolean left=sc.nextBoolean();
        if(left){
            System.out.println("Enter the value of left: ");
            int value=sc.nextInt();
            Node node1=new Node(value);
            node.left=node1;
            populate(sc, node.left);
        }
        System.out.println("Do you want to enter at the right of " + node.value);
        boolean right=sc.nextBoolean();
        if(right){
            System.out.println("Enter the value of right: ");
            int value=sc.nextInt();
            Node node1=new Node(value);
            node.right=node1;
            populate(sc, node.right);
        }
    }
    //preOrder traversal
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node) {
        if(node==null){
            return;
        }
        System.out.println(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    //inOrder traversal
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node) {
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.value + " ");
        inOrder(node.right);
    }
    //postOrder traversal
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node) {
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value + " ");
    }
    //display
    public void display(){
        display(root,"");
    }
    private void display(Node node, String indent) {
        if(node==null){
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent+'\t');
        display(node.right, indent+'\t');
    }
    //prettyDisplay
    public void prettyDisplay(){
        prettyDisplay(root, 0);
    }
    private void prettyDisplay(Node node, int level) {
        if(node==null){
            return;
        }
        prettyDisplay(node.right, level+1);
        if(level!=0){
            for (int i = 0; i < level-1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|-------->" + node.value);
        }
        else{
            System.out.println(node.value);
        }
        prettyDisplay(node.left, level+1);
    }
}
