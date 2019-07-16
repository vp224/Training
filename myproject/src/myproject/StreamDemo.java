package myproject;

import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;

public class StreamDemo {
	public static void main(String[] args) {
		
		String[] arr = {"the","eim","of","e","persio"};
		List<String> l = Arrays.asList(arr);
		l.stream().forEach(e -> System.out.println(" "+" "+e));
		
		l.stream().forEach(System.out::println);
		
		//map 
		
		String l1[]  =l.stream().map( e -> e + "!").toArray(String[]::new);
		
		for(String n:l1) {
			System.out.println(n);
		}
		String l2[] = l.stream().map(e -> e.toUpperCase()).toArray(String[]::new);
		for(String n:l2) {
			System.out.println(n);
		}
		
		String l3[] = l.stream().filter(e -> e.length()<4).toArray(String[]::new);
		for(String n:l3) {
			System.out.println(n);
		}
		
		String l31 = l.stream().reduce("",(e1,e2) -> e1.toUpperCase()+e2.toUpperCase());
		System.out.println(l31);
		String l4=l.stream().map(e ->e.toUpperCase()).reduce("",String::concat);
		System.out.println(l4);
		
		String l5 = l.stream().reduce((e1,e2) -> e1+","+e2).orElse("wrong inout");
		System.out.println(l5);
		int size = 100000;
		double a[] = new Random().doubles(size).toArray();
		double sum = DoubleStream.of(a).map(Math::sqrt).sum();
		System.out.println(sum);
		
		double sum1 = DoubleStream.of(a).parallel().map(Math::sqrt).sum();
		System.out.println(sum1);
		
		
	}
}
