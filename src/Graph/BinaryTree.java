package src.Graph;
public class BinaryTree {
    // class Node{
    //     int vertices;
    //     Node left;
    //     Node right;
    //     Node(int vertices){
    //         this.vertices = vertices;
    //         this.left =null;
    //         this.right =null;
    //     }
    // }
    // int tree[];

    int vertices;
    int tree[];
    BinaryTree(int vertices){
        this.vertices = vertices;
        tree = new int[vertices];

    }
    
    public int findparent(int P){
        for(int i=0; i<tree.length;i++){
            if(P==tree[i]){
                return i;
            }
        }
        return 0;
    }

    public void addRight(int child, int parent){
        if(parent == -1){
            tree[0]=child;
        }
        else{
            int pindx= findparent(parent);
            tree[2*pindx+2]=child;
        }

    }

    public void addLeft(int child, int parent){
        if(parent == -1){
            tree[0]=child;
        }
        else{
            int pindx= findparent(parent);
            tree[2*pindx+1]=child;
        }

    }

    // public void print_tree(){
    //     for(int i=0; i<tree.length;i++){
    //         if(tree[i] != -1){
    //             System.out.print(tree[i]);
    //         }else{
    //             System.out.print("-->");
    //         }
    //     }
    // }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(5);

        bt.addLeft(1, 0);
        bt.addLeft(2, 0);
        bt.addRight(3, 2);
        bt.addRight(4, 1);
        // bt.print_tree();

    }


}
