package implementation;

public class DetectRemoveCy {
    Node head = null;
    Node A = head;
    Node B = head;
    static class Node{
        int data;
        Node next;

        Node (int data){
            this.data = data;
            this.next=null;
        }
    }

    boolean detectCycle(){
        while(A!=null){
            A = A.next.next;
            B = B.next;

            if (A==B){
                return true;
            }
        }
        return false;
    }

    public int removeCycle(){
        if(A==B){
            while(B.next != A){
                B = B.next;
            }
            A.next= null;
        }
        return 1;

        // while(B.next != A){
        //     B= B.next;
        //     if(A==B){
        //         A.next =null;
        //     }
        //     return 1;
        // }
    }
    
}
