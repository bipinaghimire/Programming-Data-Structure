package tasks;

import java.util.Stack;

// Show how to implement a queue using two stacks. Analyze the running time of the
// queue operations.

public class TwoStacksQ {
    Stack<Integer> input = new Stack();
    Stack<Integer> output = new Stack();

    public void enqueue(int x){
        input.push(x);
    }

    public int dequeue(){
        peek();
        return output.pop();
    }

    public int peek(){
        if(output.empty()){
            while(!input.empty())
                output.push(input.pop());
            
        }
        return output.peek();
    }
    public boolean isEmpty(){
        return input.empty() && output.empty();
    }

    public static void main(String[] args) {
        TwoStacksQ q = new TwoStacksQ();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println("1st = " + q.dequeue());
        System.out.println("2nd = " + q.dequeue());
        System.out.println("3rd = " + q.dequeue());


    }

}
