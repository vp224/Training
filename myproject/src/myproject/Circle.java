package myproject;

public class Circle {
	
	private double radius;
	public double getRadius() {
		return radius;
	}
	public Circle(double radius)
	{
		this.radius = radius ;
		
	}
	public String getShapeName()
	{
		return "circle";
	}
	public double getArea(Circle c) {
		return c.radius*c.radius*3.1444 ;
	}
	
}
