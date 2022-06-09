package src.Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class AdjList {
    LinkedList [] a;
    int vertices;
    AdjList(int vertices){
        a= new LinkedList[vertices];
        this.vertices = vertices; 
        // creating array whose size == no of vertices which is connected to a linked list
        for (int i=0;i<vertices;i++){
            a[i] =new LinkedList();
        }
    }

    public void addEdge(int s, int d){
        a[s].add(d);
        a[d].add(s);
    }

    public void printGraph(){
        for(int i= 0; i<vertices;i++){   
            if(a[i].size()>0){    
                System.out.print(i+"--->"); 
            for(int j =0;j<a[i].size();j++){
                System.out.print(a[i].get(j)+"-->");
            }  
            System.out.println("null");
            }      
        }
    }

    public ArrayList getAnyNode(int i){
        ArrayList listData= new ArrayList();
        for(int j =0; j< i;j++){
            listData.add(j);
        }
        return listData;
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
