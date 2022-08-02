package Threading;

public class MatrixMultiply implements Runnable{
    int result[][];
    int a[][];
    int b[][];
    int row;
    MatrixMultiply (int a[][], int b[][], int row, int result[][]){
        
        this.a=a;
        this.b=b;
        //result=new int[a.length][a.length];
        this.row=row;
        this.result=result;
    }
  
   void multiply() {
       
        for(int row=0;row<a.length;row++) {
            
            for(int column=0;column<a.length;column++) {
                result[row][column]=0;
                
                for(int k=0;k<b.length;k++) {
                    result[row][column]=result[row][column]+b[row][k]*a[k][column];
                }
                
            }
        }
   }
   
   void multiply2() {
        for(int column=0;column<a.length;column++) {
            result[row][column]=0;
            
            for(int k=0;k<b.length;k++) {
                result[row][column]=result[row][column]+b[row][k]*a[k][column];
            }
            
        } 
   }
@Override
public void run() {
    multiply2();
    
}
public static void main(String [] args) {
    int a[][]= {{1,2},{2,3}};
    int b[][]= {{2,3},{3,4}};
    int result[][]=new int[a.length][a.length];;
    Thread t1=new Thread(new MatrixMultiply (a,b,0,result));
    Thread t2=new Thread(new MatrixMultiply (a,b,1,result));
    t1.start();
    t2.start();
    
}
    
}