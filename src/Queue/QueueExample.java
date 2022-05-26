package src.Queue;

public class QueueExample {
    int queues[];
    int front=-1;
    int rear=-1;
    int size;
    QueueExample(int size){
        this.size=size;
        queues=new int[size];
    }

    public boolean enqueue(int data){
        if(isFull()){
            System.out.println("queue overflow");
            return false;
        }
        if(front==-1){
            front=0;
        }
        queues[++rear]=data;
        return true;
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("queue underflow");
            return -9999999;
        }
        int val=front;
        if(front==rear){
            front=rear=-1;
        }
        else{
            front++;
        }
        return queues[val];

    }

    public boolean isEmpty(){
        return front==-1;
    }

    public boolean isFull(){
        return rear==size-1;
    }

public static void main(String [] args){
    QueueExample q=new QueueExample(5);
    q.enqueue(10);
    q.enqueue(20);
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
}
    
}
