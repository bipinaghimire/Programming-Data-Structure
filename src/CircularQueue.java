package src;

public class CircularQueue {
    int rear=-1;
    int front=-1;
    int [] queues;
    int size;

    CircularQueue(int size){
       this.size=size;
     queues=new int[size]; 
    }

public boolean enqueue(int data){
    if(isfull()){
        System.out.println("queue overflow");
        return false;
    }
    if(front==-1){
        front=0;
    }
    rear=(rear+1)%size;
    queues[rear]=data;
    return true;
}

public int dequeue(){
if(isEmpty()){
    System.out.println("queue underflow");
    return -9999;
}
int val=front;
if(front==rear){
  front=rear=-1;
}
else{
    front=(front+1)%size;
}
return queues[val];
}

boolean isEmpty(){
    return front==-1;
}

boolean isfull(){
  return (rear+1)%size==front;  
}
    
}
