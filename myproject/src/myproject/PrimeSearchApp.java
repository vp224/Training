package myproject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrimeSearchApp {
	
	public static void main(String[] args) throws Exception{
		RunnablePrimerSearch t1 =new RunnablePrimerSearch(1,100000);
		RunnablePrimerSearch t2 = new RunnablePrimerSearch(100000, 250000);
		Thread s1=new Thread(t1);
		Thread s2=new Thread(t2);
		
		s1.start();
		s2.start();
		
		s1.join();
		s2.join();
		//W1.COUNT 
		//W2.COUNT
		
		ExecutorService pool = Executors.newFixedThreadPool(4);
		pool.execute(s1);
		pool.execute(s2);
		
		
	}

}
