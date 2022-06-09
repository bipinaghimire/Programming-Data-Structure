package src.Graph;

import src.Graph.SinglyLinkedLIst.Node;

public class AdjList {
    SinglyLinkedLIst[] a;
    int vertices;

    AdjList(int vertices){
        a= new SinglyLinkedLIst[vertices];
        this.vertices = vertices; 
        // creating array whose size == no of vertices which is connected to a linked list
        for (int i=0;i<vertices;i++){
            a[i] =new SinglyLinkedLIst();
        }
    }

    public void addEdge(int s, int d){
        a[s].addNode(d);
        a[d].addNode(s);
    }

    public void printGraph(){
        for(int i= 0; i<vertices;i++){   
            if(a[i].getSize()>0){    
                System.out.print(i+"--->"); 
            for(int j =0;j<a[i].getSize();j++){
                System.out.print(a[i].getDataAtAnyPos(j)+"-->");
            }  
            System.out.println("null");
            }      
        }
    }
    public int [] getAnyNode(int i){
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
  
    public static void main(String[] args) {
        AdjList adjacentlist = new AdjList(5);
        
        adjacentlist.addEdge(0,1);
        adjacentlist.addEdge(0, 4);
        adjacentlist.addEdge(1, 2);
        adjacentlist.addEdge(1, 3);
        adjacentlist.addEdge(1, 4);
        adjacentlist.addEdge(2, 3);
        adjacentlist.addEdge(3, 4);
        adjacentlist.getAnyNode(1);
        
        adjacentlist.printGraph();
    }
}
