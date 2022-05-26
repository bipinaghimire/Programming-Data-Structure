package src.linkedlist;

public class DoubleLL {
    Node head=null;
    Node tail=null;
    public static class  Node{
        Node next;
        Node prev;
        int data;
        Node(int data){
            this.data=data;
            this.prev=null;
            this.next= null;
        }
    }
    public void append(int data){
        Node newnode = new Node(data);
        if(head==null){
            head = newnode;
            tail = newnode;
        }
        else{
            tail.next= newnode;
            newnode.prev = tail;
            tail = newnode;
        }
    }

    public void printList(){
        if(head==null){
            System.out.println("empty");
            return;
        }
        Node currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode.data + "->");
            currentNode =currentNode.next;
        }
        // to move backwards
        // Node currentNode = tail;
        // while(currentNode != null){
        //     System.out.print(currentNode.data + "->");
        //     currentNode =currentNode.prev;}


        System.out.println("null");
    }

    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.append(10);
        dll.append(20);
        dll.append(30);
        dll.append(40);
        dll.printList();
    }
}
