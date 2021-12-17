public class Point {
	
	String name;
	int coordX, coordY;
	
	//Constructor for points, taking the name and x,y coords
	public Point(String n, int x, int y) {
		name = n;
		coordX = x;
		coordY = y;
	}
	
	//Constructor for points, taking another point object
	public Point(Point point) {
		name = point.name;
		coordX = point.coordX;
		coordY = point.coordY;
	}
	
	//Get the name of the point
	public String getName() {
		return name;
	}
	
	//Get the X coordinate of the point
	public int getCoordX() {
		return coordX;
	}
	
	//Get the Y coordinate of the point
	public int getCoordY() {
		return coordY;
	}
	
	//Set the name of the point
	public void setName(String n) {
		name = n;
	}
	
	//Set the X coordinate of the point
	public void setCoordX(int x) {
		coordX = x;
	}
	
	//Set the Y coordinate of the point
	public void setCoordY(int y) {
		coordY = y;
	}
	
	//Get the distance between two points
	public float distance(Point p2) {
		
		//Get the X & Y differences
		int differenceX = this.coordX - p2.getCoordX();
		int differenceY = this.coordY - p2.getCoordY();
		
		return (float) Math.sqrt(differenceX * differenceX + differenceY * differenceY);
	}
	
	public String toString() {
		return "(" + name + ", " + coordX + ", " + coordY + ")";
	}
}
