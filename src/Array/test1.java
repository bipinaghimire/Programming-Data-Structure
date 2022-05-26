package src.Array;
public class test1{
static int a[];
static int size=0;
test1(int length){
    a = new int[length];

    for(int i=0; i<a.length-1; i++){
        a[i]=100+i;
        size++;
    }
}

public void inserAtAnyPos(int pos,int data){
    for(int i=size;i>pos-1;i--){
        a[i]=a[i-1];
    }
a[pos-1]=data;
}

public static void main(String [] args) {
    test1 t=new test1(5);
    System.out.println("print before insertion:");
    for(int i=0;i<a.length;i++){
        System.out.println(a[i]);
    }
    t.inserAtAnyPos(2, 200);
    System.out.println("print after insertion");
    for(int i=0;i<=a.length;i++){
        System.out.println(a[i]);
    }
}
}