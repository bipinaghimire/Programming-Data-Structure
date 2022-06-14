package src.Graph;

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
    public void BFS(int rootnode){
        System.out.println("printing bfs");
        boolean visited [] =new boolean[vertices];
        QueueG queue=new QueueG(vertices);
        visited[rootnode]=true;
        queue.enqueue(rootnode);
        while(!queue.isEmpty()){
            int x=queue.dequeue();
            int adjlist[]=getAdjNodes(x);
            for(int i=0;i<adjlist.length;i++){
                int adjval=adjlist[i];
                if(!visited[adjval]){
                    queue.enqueue(adjval);
                    visited[adjval]=true;
                }
            }
                System.out.println(x);
        }
    }

    public void DFS(int rootnode){
        System.out.println("printing dfs");
        boolean visited [] =new boolean[vertices];
        StackG stack = new StackG(vertices);
        stack.push(rootnode);
        visited[rootnode]=true;
      
        while (!stack.isEmpty()){
            int x = stack.pop();
            int[] adjlist = getAdjNodes(x);
            for(int i=0;i<adjlist.length;i++ ){
                int adjval=adjlist[i];
                if(!visited[adjval]){
                    visited[adjval]=true;
                    stack.push(adjval);
                }
            }
            System.out.print(x);
        }
    }


    public void DFSRec(int x, boolean visited []){
        visited[x] = true;
        System.out.print(x);
        for(int i: getAdjNodes(x) ){
            if(!visited[i]){
                DFSRec(i, visited);
            }
        }
    }

    public void DFSresult(int root){
        boolean visited [] =new boolean[vertices];
        System.out.println("DFS traversal");
        DFSRec(root, visited); 
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
        g.addEdge(3,2);
        g.addEdge(2,4);
        g.addEdge(1,4);
        g.addEdge(3,1);
        g.addEdge(2,0);
        g.printGraph();
        // g.printGraph1();

        g.BFS(0);
        g.DFSresult(0);
        g.DFS(0);
    }

} 
