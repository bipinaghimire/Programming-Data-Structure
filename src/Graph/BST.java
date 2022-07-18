package src.Graph;

public class BST {
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
       
       public static Node createBST(int data,Node rootnode){
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
    
       public static boolean search(Node rootnode, int k){
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


       public static Node delete(Node rootnode, int k){
        //searching node that is to be deleted
        if(rootnode.data> k){
            rootnode.left = delete(rootnode.left, k);
        }else if(rootnode.data <k){
            rootnode.right = delete(rootnode.right, k);
        }else{// root.data == value
            //case 1: delete leaf node
            if(rootnode.left==null&& rootnode.right==null){
                // null is returned to cut out the connection between the parent of leaf node
                return null;
            }
            // case 2: one child
            if(rootnode.left == null){
                return rootnode.right;
            }
            if(rootnode.right == null){
                return rootnode.left;
            }
            // case 3 : two childs
            // found sucessor from right side minimum value from right side
            Node replacingData = sucessor(rootnode.right);
            //attaching the new data ie updating the data
            rootnode.data = replacingData.data;
            //delete the succesor from right tree and update it
            rootnode.right =delete(rootnode.right, replacingData.data);
        }
        return rootnode;
       }

       //node that will replace when a element is deleted
       public static Node sucessor(Node rootnode){
        while (rootnode.left!= null){
            rootnode = rootnode.left;
        }
        return rootnode;
       }
       
       public static void inorder(Node rootnode){
        if(rootnode == null){
            return;
        }
        inorder(rootnode.left);
        System.out.print(rootnode.data+"-->");
        inorder(rootnode.right);
       }
       public static void main(String[] args) {
        int values[] = {5,9,1,4,2,3};
        Node rootnode = null;

        for(int i=0; i<values.length;i++){
            rootnode = createBST(values[i],rootnode);
        }
        inorder(rootnode);
        System.out.println(); 
        if(search(rootnode,11)){
            System.out.println("found");
        }else{
            System.out.println("Not found");
        }

        delete(rootnode, 5);
        inorder(rootnode);
       }
}
