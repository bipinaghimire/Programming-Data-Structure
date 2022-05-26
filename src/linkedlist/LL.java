package src.linkedlist;

public class LL {
    Node head;

    static int size;
    LL(){
        LL.size =0;
    }
    static class Node{
        int data;
        Node next;
        Node (int data){
            this.data = data;
            this.next=null;
            size++;
        }
    }
    // add first
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next =head;
        head=newNode;
    }

    // add last
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }

        Node currNode = head;
        while (currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next =newNode;
    }

    // print
    public void printList(){      
        if(head ==null){
            System.out.println("list is empty");
            return;
        }
        Node currNode = head;
        while (currNode != null){
            System.out.print(currNode.data +"-->");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    // delete first
    public void deleteFirst(){
        if(head==null){
            System.out.println("the list is empty");
            return;
        }
        size--;
        head = head.next;
    }

    // delete last
    public void deleteLast(){
        if(head==null){
            System.out.println("the list is empty");
            return;
        }

        size--;

        if(head.next==null){
            head =null;
            return;            
        }
        Node secondLast = head;
        Node lastNode = head.next;  

        while(lastNode.next != null){
            lastNode =lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next =null;
    }

    public int getSize(){
        return size;
    }

    public static void main(String[] args) {
        LL list = new LL();
        list.addFirst(3);
        list.addFirst(4);
        list.printList();
        list.addLast(55);
        list.printList();
        list.addFirst(1);
        list.printList();

        list.deleteFirst();
        list.printList();

        list.deleteLast();
        list.printList();

        System.out.println(list.getSize());

        list.addFirst(1);
        list.printList();
        System.out.println(list.getSize());
    }
}
