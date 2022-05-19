package src;

public class StackExample {
    int stk[];
    int top = -1;
    int size;
    StackExample(int size){
        stk = new int[size];
        this.size=size;
    }
    
    public boolean push(int data){
        if(isFull()){
            System.out.println("stack overflow");
            return false;
        }
        // top++; or
        stk[++top]=data;
        return true;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("stack underflow");
            return -999999;
        }
        // int x= top;
        // top--;
        // return stk[x]; or
        return stk[top--];
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("stack is not full");
            return -999999;
        }
        return stk[size-1];     
    }

    public boolean isEmpty(){
        // indicates empty stack
        return top == -1;
    }
    
    public boolean isFull(){
        
        return top== size-1;
        // size-1 indicates the last index and is full
        // if (top =size-1){
        //     return true;
        // }
        // return false
    }
}
