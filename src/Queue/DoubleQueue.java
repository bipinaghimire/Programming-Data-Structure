package src.Queue;

public class DoubleQueue {
    int queue[];
    int front =-1;
    int rear=-1;
    int size;
    DoubleQueue(int size){
        this.size=size;
        queue=new int[size];
    }

    public boolean enqueue(int data){
        if (isFull()){
            System.out.println("queue overflow");
            return false;
        }
        if(front==-1){
            front=0;
        }
        queue[++rear]=data;
        return true;
    }

    public boolean isEmpty(){
        return front==-1 && rear==-1;
    }

    public boolean isFull(){
        return rear==size-1;
    }
}
