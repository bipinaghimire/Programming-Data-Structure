package implementation;

public class QueueImp {
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
        if(front == null){
            rear= newnode;
            front = rear;
        }
        else{
            rear.next = newnode;
            rear = rear.next;
        }
        size ++;
    }
    public int dequeue(){
        if(front !=null){
            int value= front.data;
            front= front.next;
            size--;
            return value;
        }
        return 0;
    }

    public void print(){
        Node current = front;
        while (current!=null){
            System.out.print(current.data + "->");
            current = current.next;
        }
    }
    public static void main(String [] args){
        QueueImp q=new QueueImp();
        q.enqueue(10);
        q.enqueue(20);
        q.print();
        System.out.println(q.dequeue());
    }
}
