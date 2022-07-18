package tasks;

public class Merge{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data= data;
            this.next=null;
        }
    }

    public Node mergeTwoLinkedList(Node headFirst, Node headSecond){
        if(headFirst == null){
            return headSecond;
        }
        if(headSecond == null){
            return headFirst;
        }
        Node headFinal = null;
        if(headFirst.data<headFirst.data){
            headFinal=headFirst;
            headFirst=headFirst.next;
        }else{
            headFinal=headSecond;
            headSecond=headSecond.next;
        }
        Node current = headFinal;
        while(headFirst!=null && headSecond!=null){
            if(headFirst.data<headSecond.data){
                current.next= headFirst;
                headFirst = headFirst.next;
            }else{
                current.next= headSecond;
                headSecond = headSecond.next;      
            }
            current = current.next;
        } 
        // if different sized list and one is null and other is not just link the head of other list 
        if(headFirst==null){
            current.next=headSecond;
        }else{
            current.next=headFirst;
        }
        return headFinal;
    }

    public Node mergeKList(Node[] list, int k){
        if(k==0){
            return null;
        }
        int i = 0;
        int j = k;
        while(j!=0){
            list[i] = mergeTwoLinkedList(list[i], list[j]);
            i++;
            j--;
            if(i>=j){
                k = j;
            }
        }
        return list[0];
    }
    public static void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}