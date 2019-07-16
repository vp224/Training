

package myproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;



interface Sayable <T>{
	Boolean better(T s1,T s2);
}


class Better{
	public static <T> T betterEntry(T s1 ,T s2,Sayable<? super T> mybetter)
	{
		return mybetter.better(s1, s2)? s1:s2;
	}
}


class StringUtils{
	//public static int eChecker(String s1,String s2) {
		//return s2.indexOf('e') - s1.indexOf('e');
	//}
	
	//public static <T> List<T> allMatches (List<T> l,Predicate<T> matchFunction) {
		//List<T> ln = new ArrayList<>();
		//for(T n : l) {
			//if(matchFunction.test(n))
				//ln.add(n);
				
		//}
		//return ln;
	//}
	
	public static <T,R> List<R> transformedList(List<T> l, Function<T,R> myFunc){
		List<T> fin = new ArrayList<>();
		for(T t :l)
		{
			fin.add((T) myFunc.apply(t));
		}
		return (List<R>) fin;
		
	}
}
public class LambdaDemo {
	
	
	
	
	public static void main(String[] args)
	{
		String[] arr = {"the","eim","of","e","persio"};
		
		for(String n:arr) {
			System.out.print(n+" ");
		}
		
		List<String> l = Arrays.asList(arr);
		Collections.sort(l, (String o1, String o2) -> {
				// TODO Auto-generated method stub
				return o1.length() - o2.length();
			}
			
		);
		System.out.println();
		for(String n1:l) {
			System.out.print(n1+" ");
		}
		Collections.sort(l, (String o1, String o2) -> {
			// TODO Auto-generated method stub
			return o2.length() - o1.length();
		}
		
		);
		System.out.println();
		for(String n1:l) {
			System.out.print(n1+" ");
		}
		Collections.sort(l, (String s1,String s2) -> {
			return s1.compareTo(s2);
		}
		);
		System.out.println();
		for(String n1:l) {
			System.out.print(n1+" ");
		}
		
		
		//Collections.sort(l,StringUtils::eChecker);
		System.out.println();
		for(String n1:l) {
			System.out.print(n1+" ");
		}
		
		String string1= "V9shnu";
		String string2 = "Spadnbictd";
		
		Circle c1 = new Circle (5);
		Circle c2 = new Circle(6);
		Circle res=Better.betterEntry( c1,c2,(s1, s2) -> s1.getArea(s1) > s2.getArea(s2));
		System.out.println(res.getRadius());
		
		
//		List<String> ans = StringUtils.allMatches(l, s -> s.length()< 4);
//		
//		System.out.println(ans);
//		List<Circle> TestCircle = new ArrayList();
//		TestCircle.add(c1);
//		TestCircle.add(c2);
//		List<Circle> newl =StringUtils.allMatches(TestCircle, s -> s.getArea(s)< 1000);
//		for(Circle t:newl) {
//			System.out.println(t.getRadius());
//		}
//		
		
		List<String> temp1 = StringUtils.transformedList(l, s -> s + "!");
		for(String o : temp1)
			System.out.println(o);
		
		List<Circle> TestCircle = new ArrayList();
		TestCircle.add(c1);
		TestCircle.add(c2);
		List<Integer>  newl = StringUtils.transformedList(l, String::length );
		for(Integer o : newl)
			System.out.println(o);
	}

}
