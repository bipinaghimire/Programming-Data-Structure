package src.Stack;

public class TestChar {

    public static void main(String[] args) {
        StackExampleChar obj = new StackExampleChar(5);
        obj.push('a');
        obj.push('b');
        obj.push('c');
        obj.push('d');
        obj.push('f');
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.peek());
    }  
    
}
