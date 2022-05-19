package implementation;

public class CircularImp {
    Node front;
    Node rear;

    int size;
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data =data;
            this.next = null;
        }
    }

    public void enqueue(int data){
        Node newnode = new Node(data);
       if(rear == null){
           newnode.next = newnode;
       }
       else{
           newnode.next = rear.next;
           rear.next = newnode;
           size++;
       }
       rear = newnode;
    }

    public int dequeue(){
        if(rear == null){
             System.out.println("queue underflow");
        }
        int value = rear.next.data;
        if(rear.next ==rear){
            rear = null;
        }
        else{
            rear.next = rear.next.next;
        }
        return value;
    }

    boolean isEmpty(){
        return size ==0;
    }

    public static void main(String[] args) {
        CircularImp  c = new CircularImp();
        c.enqueue(10);
        c.enqueue(20);
        c.enqueue(30);
        System.out.println(c.dequeue());

    }
}
