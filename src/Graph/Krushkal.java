package src.Graph;

import java.util.Arrays;

public class Krushkal {

int vertices;
Edge edges[];
Krushkal(int vertices){
    this.vertices=vertices;
    edges=new Edge[vertices];
}
    
public static class Edge implements Comparable<Edge>{
int u;
int v;
int w;
Edge(int u, int v, int w){
    this.u=u;
    this.v=v;
    this.w=w;

}
@Override
public int compareTo(Edge o) {
    return this.w-o.w;
}
}
int indx=-1;
void addEdge(int u, int v, int w){
edges[++indx]=new Edge(u, v, w);
}


void  KrushkalAlgo(){

    int mst[][]=new int[vertices][vertices];
   // Edge mst[]=new Edge[vertices];
    int edgecounter=-1;
    int edgeTaken=1;
    Arrays.sort(edges);

    int parent[]=new int[vertices];
    int size[]=new int[vertices];

    for(int i=0;i<vertices;i++){
        parent[i]=-1;
    }

    while(edgeTaken<=vertices-1){
    Edge e=edges[++edgecounter];
    if(find(e.u, parent, size)==find(e.v, parent, size)){
        continue;
    }
mst[e.u][e.v]=e.w;
mst[e.v][e.u]=e.w;
// int mstindx=-1;
// mst[++mstindx]=e;
union(e.u, e.v, parent, size);
edgeTaken++;
    }
  
}

    void union(int uroot, int vroot,int parent[],int size[]){

        if(size[uroot]>size[vroot]){
            parent[vroot]=uroot;
        }
       else if(size[uroot]<size[vroot]){
            parent[uroot]=vroot;
        }
        else{
            parent[uroot]=vroot;
            size[vroot]++;
        }
    }

    int find(int u,int parent[],int size[]){
        if(parent[u]==-1){
            return u;
        }
       return  parent[u]=find(parent[u],parent,size);
    }

    public static void main(String[] args){
        Krushkal k=new Krushkal(5);
        k.addEdge(0,1,20);
    }
}
