package src.Graph;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import src.Graph.SinglyLinkedLIst.Node;

public class GraphAdjList {
  
    SinglyLinkedLIst [] a;
    int vertices;

    GraphAdjList(int vertices){
    a=new SinglyLinkedLIst[vertices];
    this.vertices=vertices;

    for(int i=0;i<vertices;i++){
        a[i]=new SinglyLinkedLIst();
    }
    }

    public void addEdge(int source,int destination){
        a[source].addNode(destination);
        a[destination].addNode(source);
    }

    public void printGraph(){
        a[0].printlist();
        for(int i=0;i<vertices;i++){
            System.out.print(i + " is connected to ");
            for(int j=0;j<a[i].getSize();j++){
                System.out.print(a[i].getDataAtAnyPos(j)+" , ");
               }
               System.out.println("");
            }
    }

    public void printGraph1(){
      for(int i=0;i<vertices;i++){
          System.out.print(i +" is connected to ");
          Node current=a[i].head;
          while(current!=null){
              System.out.print(current.data+" , ");
              current=current.next;
          }
          System.out.println("");
      }
        
    }

    public int [] getAdjNodes(int i){
        int [] list=new int [a[i].getSize()];
        int indx=0;
        Node current=a[i].head;
        while(current!=null){
            //System.out.print(current.data+" , ");
            list[indx++]=current.data;
            current=current.next;
        }
       return list; 
    }

    public static void main(String [] args){
        GraphAdjList g=new GraphAdjList(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.printGraph();
        g.printGraph1();
    }

}
