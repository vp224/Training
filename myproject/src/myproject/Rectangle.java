package myproject;

public class Rectangle {
private 	int width;
private int height;
public Rectangle(int height, int width)
{
	this.height= height;
	
	this.width= width;
}

public String getShapeName()
{
	return "Rectangle";
}
public double getArea(Rectangle c) {
	return c.width*c.height ;
}


}
