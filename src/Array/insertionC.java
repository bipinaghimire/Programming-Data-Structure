package src.Array;
public class insertionC{
    static int  a[];
    static int b[];
    static int size=5;
insertionC(int length){
    a=new int[size];
    b=new int[length];

    for(int i=0;i<a.length-1;i++){
        a[i]=100+i;
        size++;
    }
}

public void inserAtAnyPos(int pos,int data){
  for(int i=0; i<b.length;i++){
        if(i<pos-1){
            b[i]=a[i];
        }
        else if(i==pos-1){
            b[i]=data;
        }
        else{
            b[i]=a[i-1];
        }
    }
}

public static void main(String[] args) {
    insertionC bnum= new insertionC(10);
    System.out.println("print before insertion:");
    for(int i=0;i<a.length;i++){
        System.out.println(a[i]);
    }

    bnum.inserAtAnyPos(2, 200);
    System.out.println("print after insertion");
    for(int i=0;i<=b.length;i++){
        System.out.println(b[i]);
    }
}

}

