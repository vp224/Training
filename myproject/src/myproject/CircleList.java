package myproject;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class CircleList {
	
	public static void main(String []args)
	{
		ArrayList<Circle> l= new ArrayList<>();
		Random rad1 = new Random();
		double rand = Math.random();
		while(!(rand < 0.01)) {
			double rad = rad1.nextInt(100);
			System.out.println(rad);
			l.add(new Circle(rad));
			rand = Math.random();
			System.out.println(rand);
		}
		
		
		//list is built
		int size1 = l.size();
		System.out.println(size1);
		l.forEach((n)-> System.out.println(n.getArea(n)));//lambda
		Iterator it = l.iterator();
		while( it.hasNext())
		{
			Circle temp = (Circle)it.next();
			double temprad = temp.getRadius();
			if(temprad < 0.5) {
				it.remove();
			}
				
			
		}
		System.out.println(l.size());
	}

}
