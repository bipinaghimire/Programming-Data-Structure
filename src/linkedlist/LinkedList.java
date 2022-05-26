package src.linkedlist;

public class LinkedList {

    Node head = null;
    static class Node{
        int data;
        Node next;

        Node (int data){
            this.data = data;
            this.next=null;
        }
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head== null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head =newNode;
    }

    public void addLast(int data){
        Node newnode = new Node(data);
        if (head==null){
            head=newnode;
        }
        else{
            Node current = head;
            while(current.next !=null){
                current =current.next;
            }
            current.next= newnode;
        } 
        }
    public void deleteFirst(){
        if(head==null){
            System.out.println("empty");
            return;
        }
        head = head.next;
    }

    public void deleteLast(){
        if(head==null){
            System.out.println("empty");
            return;
        }

        if(head.next==null){
            head =null;
            return;            
        }
        Node secondlast = head;
        Node lastNode = head.next;

        while (lastNode.next !=null){
            lastNode=lastNode.next;
            secondlast = secondlast.next;
        }
        secondlast.next=null;
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
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(3);
        ll.printList();
        ll.addLast(55);
        ll.printList();
        ll.addFirst(1);
        ll.printList();

        ll.deleteFirst();
        ll.printList();

        ll.deleteLast();
        ll.printList();

    }
}
