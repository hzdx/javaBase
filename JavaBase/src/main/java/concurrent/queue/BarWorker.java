package concurrent.queue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

class BarWorker implements Runnable {  
  
  private static AtomicBoolean exists = new AtomicBoolean(false);  
  
  private String name;  
  
  public BarWorker(String name) {  
   this.name = name;  
  }  
  
  public void run() { 
	  System.out.println(Thread.currentThread().getName()+" is running!..");
   if (exists.compareAndSet(false, true)) { 
	   System.out.println(Thread.currentThread().getName()+" is running!..");
    System.out.println(name + " enter");  
    try {  
     System.out.println(name + " working");  
     TimeUnit.SECONDS.sleep(2);  
    } catch (InterruptedException e) {  
     // do nothing  
    }  
    System.out.println(name + " leave");  
    exists.set(false);  
   }else{  
    System.out.println(name + " give up");  
   }  
  }  
  
 }  