public interface Polyline extends java.lang.Iterable<Point>
{
	Point[] getPoints();
	
	String getColor();
	
	int getWidth();
	
	float length();
	
	void setColor(String color);
	
	void setWidth(int width);
	
	void addPoint(Point newPoint);
	
	void addPoint(Point newPoint, String pointName);
	
	void remove(String pointName);
	
	java.util.Iterator<Point> iterator();
}