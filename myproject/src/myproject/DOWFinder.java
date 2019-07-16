package myproject;

public class DOWFinder{
	static String findDOW(int day,int month,int year) {
		
	 
		int numberdays = (year - 1900)*365 ;
		int missingleap = numberdays+ (year-1900)/4 ;
		boolean leap= false;
		if(year%4==0)
		{
			if(year%100 ==0)
			{
				if(year%400 ==0)
					leap = true ;
				else
					leap = false;
				    
			}
			else 
				leap=true;
			
		}
		else
			leap = false;
		if(leap && (month==1 || month == 2 ))
		{
			missingleap = missingleap -1 ;
		}
		switch(month){
		 
		 case 12 : missingleap +=31;
		 case 11 : missingleap +=30;
		 case 10: missingleap+=31;
		 case 9: missingleap+=30;
		 case 8: missingleap+=31;
		 case 7: missingleap+=31;
		 case 6: missingleap+=30 ;
		 case 5: missingleap+=31;
		 case 4: missingleap+= 30;
		 case 3: missingleap+=31;
		 case 2: missingleap+=28;
		 case 1:missingleap+=31;
		 
			 
		 }
		missingleap+=day;
		int ind = missingleap%7;
		String days[]= {"sunday","monday","tuesday","wednesday","thursday","friday","saturday"};;;;;;
		return days[ind];
	}
	public static void main(String[] args) {
		
		String ans = findDOW(8,7,2019);
		System.out.println(ans);
		
	}

}
