package src.Graph;

public class SinglyLinkedLIst {

    public static class Node{
     Node next;
     int data;
     Node(int data){
         this.data=data;
         this.next=null;
     }
    }

    Node head=null;
    Node tail=null;
    int size=0;

public void addNode(int data){
    size++;
    Node newnode=new Node(data);
    if(head==null){
        head=tail=newnode;
    }
    else{
        tail.next=newnode;
        tail=newnode;
    }
}

public int getSize(){
    return size;}

public int getDataAtAnyPos(int pos){
    Node current=head;
    //0
    for(int i=1;i<=pos;i++){
        current=current.next;
    }
    return current.data;
}
public void printlist(){
    Node current=head;
    while(current!=null){
        System.out.println(current.data);
        current=current.next;
    }
}
public static void main(String [] args){
    SinglyLinkedLIst list=new SinglyLinkedLIst();
    list.addNode(10);
    list.addNode(20);
    System.out.println(list.getDataAtAnyPos(2));
    System.out.println(list.getSize());
    list.printlist();
    
}

}
