package Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        // CustomStack stack =new CustomStack(5);
        // stack.push(1);
        // stack.push(2);
        // stack.push(3);
        // stack.push(4);
        // stack.push(5);
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.peek());
        DynamicStack dStack=new DynamicStack();
        dStack.push(1);
        dStack.push(2);
        dStack.push(3);
        dStack.push(4);
        dStack.push(5);
        System.out.println(dStack.pop());
        System.out.println(dStack.pop());
        System.out.println(dStack.pop());
        System.out.println(dStack.pop());
        System.out.println(dStack.pop());
    }
}
