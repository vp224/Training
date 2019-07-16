package myproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class StringComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o1.length()
				-o2.length();
	}
	
}
public class MapEmployee {
	
	public static <T> void mySort(List<T> l,Comparator<? super T> c) {  // comparator can be of anysupercalss of T
		
		
	}
	public static void main(String[] args) {
		//fun();
		
		//listfun();
		
		listsort();
		
		List<String>  iq = new ArrayList<>();
		StringComparator c = new StringComparator();
		mySort(iq,c);
	}
	
	private static void listsort() {
		String[] l1 = {"a","b","z","e"};
		//converting arary into collecton usnig arrays
		
		List<String> l = Arrays.asList(l1);
		
		Collections.sort(l, new StringComparator());//sorted
		//anonymous inner class
		Collections.sort(l,      new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.length() - o2.length();
			}
			
		});
		
		
		
	}
	private static void listfun() {
		Set<String>  s = new HashSet<>(); // LinkedHashSet maintains a linked list internal to hashset to etrieve stable
		while(true)
		{
			System.out.println("Enter the word");
			Scanner s1 = new Scanner(System.in);
			String str = s1.nextLine();
			if(!s.add(str)) {
				System.out.println("added dup");
			}
			if(s.size() == 10)
				break;
		}
		
		// print the set
	}
	private static void fun() {
		HashMap<String,String> hm = new HashMap<String,String>();
		hm.put("e1234","Steve jobs");
		hm.put("e2345","Bill Gates");
		hm.put("e3456","Larry Ellison");
		hm.put("e4567","Jeff bezos");
		hm.put("e8765","mark");
		hm.put("e6789","Larry page");
		
		System.out.println("Enter the empid");
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		String ret = hm.get(str);
		
		System.out.println(ret);
	}
}
