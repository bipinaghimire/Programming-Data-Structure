package Threading;

public class ThreadTest {
    
    
    int[][] matrixMultiplication(int [][] a, int [][]b) {
        
        int result[][]=new int [a.length][a.length];
        
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<b.length;j++) {
                result[i][j]=0;
                for(int k=0;k<b.length;k++) {
                    result[i][j]=result[i][j]+a[i][k]*b[k][j];
                }
            }
        }
        
        return result;
    }
    
  public void mulitply(int row, int[][] a, int [][] b,int [][] result) {
      
      for(int j=0;j<a.length;j++) {
            result[row][j]=0;
            for(int k=0;k<a.length;k++) {
                result[row][j]=result[row][j]+a[row][k]*b[j][k];
            }
        }
  }

 

    
    
    
    void display(int [][] a) {
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a.length;j++) {
                System.out.print(a[i][j]+", ");
            }
            System.out.println("");
        }
    }
    
    
    public  class Task implements Runnable{
        
        int a[][];
        int b[][];
        int result[][];
        int row;
        Task(int row, int[][] a, int [][] b,int result[][]){
            
            this.a=a;
            this.b=b;
            this.row=row;
            this.result=result;
        }
        
        
        @Override
        public void run() {
             System.out.println(
                        "Current Thread Name: "
                        + Thread.currentThread().getName());
            mulitply(row,a,b,result);
            
        }
        
    }
    
    void executeTask(int [] [] a, int b[][],int result[][]) {
        Thread t1=new Thread(new Task(0,a, b,result));
        Thread t2=new Thread(new Task(1,a, b,result));
        t1.start();
        t2.start();
    }
    
    public static void main(String [] args) {
        int a[][]= {{1,2},{2,3}};
        int b[][]= {{2,3},{3,4}};
        int result[][]=new int [a.length][b.length];
        
        ThreadTest th=new ThreadTest();
        
        System.out.println("prinnting matrix a");
        th.display(a);
        System.out.println("printing matrix b");
        th.display(b);
        
        th.executeTask(a, b,result);
        System.out.println("printing reslt");
        th.display(result);
        
        
        
    }

 

}
