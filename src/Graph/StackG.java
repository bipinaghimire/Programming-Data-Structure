package src.Graph;

public class StackG {
    int stk[];
    int top = -1;
    int size;
    StackG(int size){
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


    // public void DFSRec(int x, boolean visited []){
    //     visited[x] = true;
    //     System.out.print(x);
    //     for(int i: getAdjNodes(x) ){
    //         if(!visited[i]){
    //             DFSRec(i, visited);
    //         }
    //     }
    // }

    // public void DFSresult(int root){
    //     boolean visited [] =new boolean[vertices];
    //     System.out.println("DFS traversal");
    //     DFSRec(root, visited);  
    // }

