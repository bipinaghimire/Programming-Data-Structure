package src.Graph;
public class AVL {
    public static class Node{
        Node left;
        Node right;
        int height;
        int data;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
            this.height=1;
        }
    }

    Node createBST(int data,Node rootnode){
        if(rootnode==null){
            return new Node(data);
        }
        if(data<rootnode.data){
            rootnode.left=createBST(data, rootnode.left);
        }
        else if(data>rootnode.data){
            rootnode.right=createBST(data, rootnode.right);
        }
        else{
            return rootnode;
        }

        rootnode.height=Math.max(getHeight(rootnode.left), getHeight(rootnode.right))+1;
        int balancefactor=getBalanceFactor(rootnode);
        //RR
        if(balancefactor<-1 && data>rootnode.right.data){
            return leftRotate(rootnode);
        }
        //RL
        if(balancefactor<-1 && data<rootnode.right.data){
            rootnode.right=rightRotate(rootnode.right);
            return leftRotate(rootnode);
        }
        //LL
        if(balancefactor>1 && data<rootnode.left.data){
            return rightRotate(rootnode);
        }
        //lR
        if(balancefactor>1 && data>rootnode.left.data){
            rootnode.left=leftRotate(rootnode.left);
            return rightRotate(rootnode);
        }

        return rootnode;
    }

Node leftRotate(Node x){
  Node y=x.right;
  Node t2=y.left;
  y.left=x;
  x.right=t2;
  x.height=Math.max(getHeight(x.left), getHeight(x.right))+1;
  y.height=Math.max(getHeight(y.left), getHeight(y.right))+1;
  return y;
}
Node rightRotate(Node y){
    Node x=y.left;
    Node t2=x.right;
    x.right=y;
    y.left=t2;
    x.height=Math.max(getHeight(x.left), getHeight(x.right))+1;
    y.height=Math.max(getHeight(y.left), getHeight(y.right))+1;
    return x;
  }

int getHeight(Node node){
 if(node==null)
 {
    return 0;
 }
 return node.height;
}

int getBalanceFactor(Node node){
    if(node==null){
        return 0;
    }
    return getHeight(node.left)-getHeight(node.right);
}

}
