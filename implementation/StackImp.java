package implementation;

public class StackImp {
    Node head;
    int size; //size of stack
    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data =data;
            this.next = null;
        }
    }

    public void push(int data){
        Node newnode = new Node(data);
        newnode.next = head;
        head = newnode;
        size++;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack underflow");
        }

        int finalvalue = head.data;
        head = head.next;
        size--;
        return finalvalue;

    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Empty");
        }
        return head.data;    
    }

    public boolean isEmpty(){
        return size == 0 ;
    }
    
    public void print(){
        Node current = head;
        while (current!=null){
            System.out.print(current.data + "->");
            current = current.next;
        }
    }
}
 