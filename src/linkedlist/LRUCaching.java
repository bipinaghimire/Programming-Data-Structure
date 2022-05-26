package src.linkedlist;
import java.util.HashMap;

public class LRUCaching {
    HashMap<Integer,Node> map;
    int capacity;
   
    public static class Node{
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key, int value){
            this.key=key;
            this.value=value;
            this.next=null;
            this.prev=null;
        }
    }

    LRUCaching(int capacity){
        this.capacity=capacity;
        map=new HashMap<>();

    }

    public void put(int key, int value){
      if(map.containsKey(key)){
          removenode(map.get(key));
      }
      else if(map.size()==capacity){
          removenode(tail);
      } 
        Node newnode=new Node(key,value);
        insert(newnode); 
    }
    Node head=null;
    Node tail=null;
    public void insert(Node node){
        map.put(node.key,node);
        if(head==null){
            head=tail=node;
        }
        else{
            node.next=head;
            head.prev=node;
            head=node;
        }
    }

    public int get(int key){
        Node node=map.get(key);
        if(node==null){
            return -1;
        }
        removenode(node);
        insert(node);   
        return node.value;     
    }
    public void removenode(Node node){
        map.remove(node.key);
        if(node==head){
            head=head.next;
            node.next=null;
            head.prev=null;
        }
        else if(node ==tail){
            tail=tail.prev;
            tail.next=null;
            node.prev=null;
        }
        else{
            node.prev.next=node.next;
            node.next.prev=node.prev;
            node.prev=null;
            node.next=null;

        }

    }
    
}
