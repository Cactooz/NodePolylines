import java.util.Arrays;

public class VPolyline {
	private Point[] points;
	private String color = "black";
	private int width = 1;
	
	public VPolyline() {
		points = new Point[0];
	}
	
	public VPolyline(Point[] points) {
		this.points = new Point[points.length];
		for(int i = 0; i < points.length; i++) {
			this.points[i] = new Point(points[i]);
		}
	}
	
	public Point[] getPoints() {
		Point[] getPoints = new Point[points.length];
		
		//Add all elements into the new array
		for(int i = 0; i < getPoints.length; i++) {
			getPoints[i] = points[i];
		}
		
		return getPoints;
	}
	
	public String getColor() {
		return color;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setColor(String newColor) {
		color = newColor;
	}
	
	public void setWidth(int newWidth) {
		width = newWidth;
	}
	
	//Get the length of the polyline
	public float length() {
		//Set the start length to 0
		float length = 0;
		
		//Add the length between the point to the next point into the total length
		for(int i = 0; i < points.length-1; i++) {
			length += points[i].distance(points[i+1]);
		}
		
		return length;
	}
	
	//Add a point to the end of the array
	public void addPoint(Point newPoint) {
		//Set a temporary array that is bigger
		Point[] tempPoints = new Point[points.length+1];
		
		//Add the old points to the array
		for(int i = 0; i < points.length; i++) {
			tempPoints[i] = points[i];
		}
		//Add the new point at the end of the array
		tempPoints[tempPoints.length - 1] = newPoint;
		
		points = tempPoints;
	}
	
	//Add a point before a point specified by its name
	public void addPoint(Point newPoint, String pointName) {
		//Set a temporary array that is bigger
		Point[] tempPoints = new Point[points.length+1];
		
		int pos = 0;
		
		//Add all the points upto the point specified by its name
		while(points[pos].getName() != pointName) {
			tempPoints[pos] = points[pos];
			pos++;
		}
		
		//Add the new point before the point with the defined name
		tempPoints[pos] = newPoint;
		
		//Add the remaining points to the end of the array
		for(int i = pos; i < points.length; i++) {
			tempPoints[i+1] = points[i];
		}
		
		points = tempPoints;
	}
	
	//Add a point to the start of the array
	public void addPointStart(Point newPoint) {
		//Set a temporary array that is bigger
		Point[] tempPoints = new Point[points.length+1];
		
		//Add the new point at the start of the array
		tempPoints[0] = newPoint;
		
		//Add the old points to the array
		for(int i = 1; i < tempPoints.length; i++) {
			tempPoints[i] = points[i-1];
		}
		
		points = tempPoints;
	}
	
	//Remove a point defined by its frame from the array
	public void remove(String pointName) {
		
		int removePos = -1;
		for(int i = 0; i < points.length; i++) {
			if(points[i].getName() == pointName) {
				removePos = i;
				break;
			}
		}
		if(removePos == -1)
			throw new IllegalArgumentException(pointName + " is not a point in the polyline");
		
		//Set a temporary array that is smaller
		Point[] tempPoints = new Point[points.length-1];
		
		//Add all points to the array up to the point with the defined name
		for(int i = 0; i < removePos; i++) {
			tempPoints[i] = points[i];
		}
		//Add the remaining items after the defined point
		for(int i = removePos; i < tempPoints.length; i++) {
			tempPoints[i] = points[i+1];
		}
		
		points = tempPoints;
	}
	
	public String toString() {
		if(points[0] == null) {
			return "Error: No points found";
		}
		return "{" + Arrays.toString(this.points) + ", " + color + ", " + width + "}";
	}
	
	public class PolylineIterator {
		private int current = -1;
		
		public PolylineIterator()
		{
			if (VPolyline.this.points.length > 0)
				current = 0;
		}
		
		public boolean pointsCheck()
		{
			return current != -1;
		}
		
		public Point point() throws java.util.NoSuchElementException
		{
			if (!this.pointsCheck())
				throw new java.util.NoSuchElementException ("End of iteration");
			
			return VPolyline.this.points[current];
		}
		
		public void forward()
		{
			if (current >= 0 && current < VPolyline.this.points.length - 1)
				current++;
			else
				current = -1;
		}
		
		public void printPunkt(){
			while(this.pointsCheck()){
				Point tempPoint = point();
				System.out.println(tempPoint);
				forward();
			}
		}
	}
}
