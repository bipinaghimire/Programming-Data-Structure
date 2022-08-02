package Threading;

public class TestThread extends Thread{
    
    @Override
    public void run() {
        for(int i=0;i<=20;i++) {
            System.out.println("child thread");
        }
        
    }
    
    public static void main(String [] args) {
        for(int i=0;i<=20;i++) {
            System.out.println("run main thead");
        }
    
    TestThread t=new TestThread();
    t.start();
    
    for(int i=0;i<=20;i++) {
        System.out.println("run main thead 2");
    }
        
    }
}
