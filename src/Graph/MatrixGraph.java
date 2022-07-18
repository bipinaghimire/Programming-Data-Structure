package src.Graph;

import src.linkedlist.LinkedList;



public class MatrixGraph {
   int vertices;
   int  matrix[][]; 
   MatrixGraph(int vertices){
       this.vertices=vertices;
       matrix=new int[vertices][vertices];

    }


   public void addEdge(int source, int destination,int weight){
        matrix[source][destination]=weight;
        matrix[destination][source]=weight;
   }

   public void printMatrix(){
       for(int i=0;i<vertices;i++){
           for(int j=0;j<vertices;j++){
               System.out.print(matrix[i][j]+" ");
           }
           System.out.println(" ");
       }
    }

    // dijkstra's algorithm
    public void dijkstra(int source,int destination){
       int distance[]=new int [vertices];
       int prevpath[]=new int[vertices];
       boolean visited[]=new boolean[vertices];

       for(int i=0;i<vertices;i++){
        distance[i]=Integer.MAX_VALUE;
        prevpath[i]=-1;
       }

       distance[source]=0; 

       for(int i=0;i<vertices;i++){
        int u=findminimumvertex(visited,distance);
        visited[u]=true;

        for(int j=0;j<vertices;j++){
            if(matrix[u][j]!=0){
                int v=j;
                int newdistance=distance[u]+matrix[u][j];
                if(newdistance<distance[v]){
                    distance[v]=newdistance;
                    prevpath[v]=u;
                }
            }
        }
    }
        
    
    System.out.println("distance from source: "+source+" to destination: "+destination+" is="+distance[destination]);
       
    int crawl=destination;
       int path[]=new int[vertices];
       int indx=0;
       while(crawl!=-1){
        path[indx++]=crawl;
        crawl=prevpath[crawl];
       }
       for(int i=indx-1;i>=0;i--){
            System.out.println(path[i]);
       }

    }

    public int findminimumvertex(boolean visited[],int distance[]){
        int minvertex=-1;
        for(int i=0;i<vertices;i++){
            if((minvertex==-1 ||distance[i]<distance[minvertex])&& !visited[i]){
                minvertex=i;
            }
            //  if(distance[i]<distance[minvertex] && !visited[i]){
            //     minvertex=i;
            // }

        }
        return minvertex;
    }


    // shortest distance for unweighted graph
    public void UnweightedShortDist(int source, int destination){
        boolean visited[]=new boolean[vertices];
        QueueG queue = new QueueG(vertices);
        int distance[] =new int[vertices];
        int prevpath[] = new int[vertices];
        for(int i=0; i<vertices;i++){
            distance[i]=Integer.MAX_VALUE;
            prevpath[i]=-1;
        }
        distance[source]=0;
        queue.enqueue(source);
        visited[source]=true;
        while(!queue.isEmpty()){
            int u = queue.dequeue();
            for(int i=0; i<vertices;i++){
                if(matrix[u][i]!=0 && !visited[i]){
                    int v=i;
                    int newdistance = distance[u]+1;
                    if(newdistance<distance[v]){
                        distance[v]= newdistance;
                        prevpath[v]= u;
                    }
                    queue.enqueue(u);
                    visited[v]=true;
                }
            }
        }
        System.out.println("distance from source: "+source+" to destination: "+destination+" is="+distance[destination]);
        int crawl=destination;
        int path[]=new int[vertices];
        int indx=0;
        while(crawl!=-1){
         path[indx++]=crawl;
         crawl=prevpath[crawl];
        }
        for(int i=indx-1;i>=0;i--){
             System.out.println("path is "+ path[i]);
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

    public void BFS(int rootnode){
        System.out.println("printing bfs");
        boolean visited [] =new boolean[vertices];
        QueueG queue=new QueueG(vertices);
        visited[rootnode]=true;
        queue.enqueue(rootnode);
        while(!queue.isEmpty()){
            int x=queue.dequeue();
            for(int i=0;i<vertices;i++){
                if(matrix[x][i]!=0 && !visited[i]){
                    queue.enqueue(i);
                    visited[i]=true;
                }
            }
            System.out.print( x+ " ");
        }
    }

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
        MatrixGraph g=new MatrixGraph(6);
        g.addEdge(0, 1,10);
        g.addEdge(0, 2,5);
        g.addEdge(0, 5,100);
        g.addEdge(1, 3,20);
        g.addEdge(1, 2,2);
        g.addEdge(2, 4,15);
        g.addEdge(3, 4,5);
        g.addEdge(3, 5,20);
        g.addEdge(4, 5,15);
        g.printMatrix();
        g.printgraph();

        g.getAdjNode(2);
        g.getAdjNode(0);

        g.UnweightedShortDist(1, 5);
        g.dijkstra(1,5 );
        g.BFS(1);
    }
}