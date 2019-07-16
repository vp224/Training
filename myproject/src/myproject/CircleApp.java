package myproject;

public class CircleApp {
		public static void main(String []args)
		{
			Circle c = new Circle(5);
			Circle d = new Circle(10);
			double ans = c.getArea(c);
			System.out.println(ans);
		}
}
