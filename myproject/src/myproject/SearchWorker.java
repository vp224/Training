

package myproject;
import java.io.File;
import java.util.*;
public class SearchWorker extends Thread{
	
	String file_name;
	Queue<File> file_que;
	List<File> file_list;
	public SearchWorker(String file_name,Queue<File> file_que,List<File> file_list) {
		super();
		this.file_name=file_name;
		this.file_que=file_que;
		this.file_list = file_list;
	}
	@Override
	public void run() {
		
		while(true) {
		File front = file_que.poll();
		if(front == null) break;
		
		
			if(front.isFile() && front.getName().equalsIgnoreCase(file_name)) {
				file_list.add(front);
			}
			
			else if(front.isDirectory() && front.canRead()) {
				File f[] = front.listFiles();
				file_que.addAll(Arrays.asList(f));
			}
		}
	}
}
