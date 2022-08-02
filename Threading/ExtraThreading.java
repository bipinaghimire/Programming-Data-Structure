package Threading;

class ca{}
// to excute multithreading synchronously 
class downloadimage{
    synchronized void download(String imagename){
        for(int i=0;i<10;i++){
            System.out.println("Downloading "+imagename+ i+".jpg");
        }
    }
}

class myTask extends Thread{
    @Override
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("image"+i+".jpg");// independently parallely execute hunxa
        }
    }
}

// class myTask extends ca implements Runnable{
//     @Override
//     public void run(){
//         for(int i=0;i<10;i++){
//             System.out.println("download image"+i+".jpg");// independently parallely execute hunxa
//         }
//     }
// }

// other example this one is by asynchronously
// class downloadimage{
//     void download(String imagename){
//         for(int i=0;i<10;i++){
//             System.out.println("download image "+imagename+i+".jpg");
//         }
//     }
// }



// multi threading is a process of executing multiple tasks at the same time
// two ota process ley eutai task lai multiple thread banayera execute gareko xam
class thread1 extends Thread{
    downloadimage downloadimage;
    thread1(downloadimage downloadimage){
        this.downloadimage=downloadimage;
    }

    @Override
    public void run(){
        downloadimage.download("dog");
    }
}

class thread2 extends Thread{
    downloadimage downloadimage;
    thread2(downloadimage downloadimage){
        this.downloadimage=downloadimage;
    }

    @Override
    public void run(){
        downloadimage.download("cat");
    }
}

public class ExtraThreading {

    public static void main(String[] args) {
        System.out.println(" download downloading image");
        // for(int i=0;i<10;i++){
        //     System.out.println("image"+i+".jpg");// if this too long will not allow other tasks to run below it
        // }
        // myTask t=new myTask();
        // t.start();

        downloadimage d=new downloadimage();
        thread1 t1=new thread1(d);
        thread2 t2=new thread2(d);
        //they are executing asynchronously
        //parallely execute vaye pani serially execute hunxa
        t1.start();
        try{
            t1.join();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        t2.start();
        System.out.println("finished printing image");
        //threading ma execute garey paxi different sequence ma execute hunxa
    }
    
}
