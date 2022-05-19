package src;

public class Test {
    public static void main(String[] args) {
        StackExample obj = new StackExample(5);
        obj.push(100);
        obj.push(200);
        obj.push(300);
        obj.push(400);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.peek());
    }   
}
