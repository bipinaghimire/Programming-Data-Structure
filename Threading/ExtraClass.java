package Threading;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
// class task implements Runnable
class task implements Callable<String>{
    @Override
    // public void run()
    public String call(){
        System.out.println("executing task ");
        System.out.println(Thread.currentThread().getName());
        return "task completed";
    }
}

public class ExtraClass{
    ExecutorService service = Executors.newFixedThreadPool(10);
    
    void executeTask(){
        for(int i=0;i<10;i++){
            // Thread t = new Thread(new task());
            // t.start();
            // service.execute(new task()); for ruunable
            service.submit(new task()); // for callable
        }
    }
    public static void main(String[] args) {
        new ExtraClass().executeTask();
        
        CompletableFuture<String> future = CompletableFuture.supplyAsync(
            ()->{
                try{
                    Thread.sleep(10000000);
                }
                catch (Exception ee){ee.printStackTrace();}// dependent variable value payepaxi execute hunxa
                return "hello";}
            ).thenApply(s->{return s+"world";});

            // future.get();
            System.out.println(future.join());// join is used to get the value of future and it is a blocking call

    }
}

//executer service