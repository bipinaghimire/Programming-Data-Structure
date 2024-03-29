package src.Graph;

import src.linkedlist.LinkedList;

public class GraphEx {
   int vertices;
   int  matrix[][]; 
   GraphEx(int vertices){
       this.vertices=vertices;
       matrix=new int[vertices][vertices];
   }


   public void addEdge(int source, int destination){
        matrix[source][destination]=1;
        matrix[destination][source]=1;
   }

   public void printMatrix(){
       for(int i=0;i<vertices;i++){
           for(int j=0;j<vertices;j++){
               System.out.print(matrix[i][j]+" ");
           }
           System.out.println(" ");
       }
    }
  
    public void printgraph(){
        for(int i=0;i<vertices;i++){
            System.out.print(i +" is connected to ");
            for(int j=0;j<vertices;j++){
                if(matrix[i][j]!=0){
                    System.out.print(j+" , ");
                }
            }
            System.out.println("");
        }
    }




    // public void getAdjNode(int i){
    //     System.out.print(i +" --->");
    //     for(int j=0;j<vertices;j++){
    //         if(matrix[i][j]!=0){
    //             System.out.print("("+ i +" , "+j+")");
    //         }
    //     }
    //     System.out.println("");
    // }

    public LinkedList getAdjNode(int i){
        LinkedList list = new LinkedList();
        for(int j =0; j<vertices;j++){
            if (matrix[i][j] !=0){
                list.addNode(j);
            }
        }
        return list;
    }

    public static void main(String [] args){
        GraphEx g=new GraphEx(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.printMatrix();
        g.printgraph();

        g.getAdjNode(2);
        g.getAdjNode(0);
    }
}