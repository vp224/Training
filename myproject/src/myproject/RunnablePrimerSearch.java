package myproject;

public class RunnablePrimerSearch implements Runnable{
	long start,end;
	int count;
	boolean res = false;
	public RunnablePrimerSearch(long start,long end) {
		this.start=start;
		this.end=end;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(long i=start;i<=end;i++)
		{
			if(isprime(i))
				count++;
			
		}
		res =false;
	}
	private boolean isprime(long i) {
		// TODO Auto-generated method stub
		
		if(i<=2) 
		return true;
		for(long n = 2;n< i;n++) {
			if(i%n ==0) {
				return false;
			}
		}
		return true;
		
		
		
		
		
		
	}
	
	
}
