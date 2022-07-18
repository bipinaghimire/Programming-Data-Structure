package src.Graph;

public class DisjointSets {
int vertices;
int parent[];
int size[];
    DisjointSets(int vertices){
        this.vertices=vertices;
        parent=new int[vertices];
        size=new int[vertices];
        for(int i=0;i<vertices;i++){
            parent[i]=-1;
        }
    }

    boolean isCycleDetected(int u, int v){
        int uroot=find(u);
        int vroot=find(v);

        if(vroot==uroot){
            System.out.println("cycle detected");
            return true;
        }
        union(uroot,vroot);
        return false;

    }
    void union(int uroot, int vroot){

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

    int find(int u){
        if(parent[u]==-1){
            return u;
        }
       return  parent[u]=find(parent[u]);
    }

    public static void main(String [] args){
        DisjointSets d=new DisjointSets(4);
        d.isCycleDetected(0, 1);
        d.isCycleDetected(0, 2);
        d.isCycleDetected(1, 3);
        d.isCycleDetected(2, 3);
    }
    
}
