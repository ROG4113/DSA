package Trees.AVLTrees;

public class AVL {
    private Node root;
    public class Node{
        private Node left;
        private Node right;
        private int value;
        private int height;
        //constructor
        public Node(int value){
            this.value=value;
        }
        public int getValue(){
            return value;
        }
    }
    //populate
    public void populate(int[] nums){
        for (int i = 0; i < nums.length; i++) {
                insert(nums[i]);
        }
    }
    //populate sorted
    public void populateSorted(int[] nums){
        populateSorted(nums, 0, nums.length);
    }
    private void populateSorted(int[] nums, int start, int end) {
        if(start>=end){
            return;
        }
        int mid=(start+end)/2;
        this.insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid+1, end);
    }
    //method to insert
    public void insert(int value){
        root=insert(value, root);
    }
    private Node insert(int value, Node node){
        if(node==null){
            node=new Node(value);
            return node;
        }
        if(value<node.value){
            node.left=insert(value, node.left);
        }
        if(value>node.value){
            node.right=insert(value, node.right);
        }
        node.height=Math.max(height(node.left), height(node.right))+1;
        return rotate(node);
    }
    private Node rotate(Node node) {
        if(height(node.left)-height(node.right)>1){
            //left heavy: It has two cases i.e. left-left case & left-right case
            if(height(node.left.left)-height(node.left.right)>0){
                //left-left case
                return rightRotate(node);
            }
            if(height(node.left.left)-height(node.left.right)<0){
                //left-right case
                node.left=leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if(height(node.left)-height(node.right)<-1){
            //right heavy: It has two cases i.e. right-right case & right-left case
            if(height(node.right.left)-height(node.right.right)<0){
                //right-right case
                return leftRotate(node);
            }
            if(height(node.right.left)-height(node.right.right)>0){
                //right-left case
                node.right=rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }
    private Node rightRotate(Node p) {
        Node c=p.left;
        Node t=c.right;
        c.right=p;
        p.left=t;
        p.height=Math.max(height(p.left), height(p.right)+1);
        c.height=Math.max(height(c.left), height(c.right)+1);
        return c;
    }
    private Node leftRotate(Node p) {
        Node c=p.right;
        Node t=c.left;
        c.left=p;
        p.right=t;
        c.height=Math.max(height(c.left), height(c.right)+1);
        p.height=Math.max(height(p.left), height(p.right)+1);
        return c;
    }
    //method to check if balanced
    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node) {
        if(node==null){
            return true;
        }
        return Math.abs(height(node.left)-height(node.right))<=1 && balanced(node.left) && balanced(node.right);
    }
    //method for height
    public int height(){
        return height(root);
    }
    private int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }
    //method to check if tree is empty
    public boolean isEmpty(Node node){
        return node==null;
    }
    //display
    public void display(){
        display(root, "Root Node: ");
    }
    private void display(Node node, String details) {
        if(node==null){
            return;
        }
        System.out.println(details + node.getValue());
        display(node.left, "left child of " + node.getValue() + " : ");
        display(node.right, "right child of " + node.getValue() + " : ");
    }
}
