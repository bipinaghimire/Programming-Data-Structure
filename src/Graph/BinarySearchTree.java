package src.Graph;


public class BinarySearchTree {
   public static class Node{
    Node left;
    Node right;
    int data;
    Node(int data){
        this.data=data;
        left=null;
        right=null;
    }
   }
   
   public Node createBST(int data,Node rootnode){
    if(rootnode==null){
       return new Node(data);
    }
    if(data<rootnode.data){
         rootnode.left=createBST(data, rootnode.left);
    }
    else{
         rootnode.right=createBST(data, rootnode.right);
    }
    return rootnode;
   }


   public boolean search(Node rootnode, int k){
     if(rootnode == null){
          return false;
     }
     if(rootnode.data>k){
          return search(rootnode.left, k);
     }else if(rootnode.data<k){
          return search(rootnode.right, k);
     }else if(rootnode.data == k){
          return true;
     }
     return false;
   }

   public static void main (String [] args){
    BinarySearchTree bst=new BinarySearchTree();
    Node rootnode=bst.createBST(10, null);
     rootnode=bst.createBST(8, rootnode);
     rootnode=bst.createBST(11, rootnode);
     bst.search(rootnode, 11);
   }
   }

