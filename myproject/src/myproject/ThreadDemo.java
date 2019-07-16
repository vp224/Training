package myproject;

import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadDemo {
	
		public static void main(String[] args) throws Exception {
			String f_nam = args[0];
			String fold_nam =args[1];
			
			File o = new File(fold_nam);
			File[] contents = o.listFiles();
			Queue<File> q = new ConcurrentLinkedQueue<>();
			q.addAll(Arrays.asList(contents));
			List<File> res = Collections.synchronizedList(new ArrayList<File>());
			
			SearchWorker s1 = new SearchWorker(f_nam, q, res);
			SearchWorker s2 = new SearchWorker(f_nam, q, res);
			SearchWorker s3 = new SearchWorker(f_nam, q, res);
			SearchWorker s4 = new SearchWorker(f_nam, q, res);
			
			s1.start();
			s2.start();
			s3.start();
			s4.start();
			s1.join();
			s2.join();
			s3.join();
			s4.join();
			
			System.out.println(res.size());
			res.forEach(f->System.out.println(f.getAbsolutePath()));
			
		}

}
