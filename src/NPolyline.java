import java.util.Arrays;
import java.util.Iterator;

public class NPolyline implements Polyline{
	public static class Node {
		public Point point;
		public Node nextNode;
		
		public Node(Point point) {
			this.point = point;
			nextNode = null;
		}
	}
	
	private Node point;
	private String color = "black";
	private int width = 1;
	
	public NPolyline() {
		point = null;
	}
	
	public NPolyline(Point[] points) {
		if(points.length > 0) {
			Node node = new Node(new Point(points[0]));
			point = node;
			int pos = 1;
			while(pos < points.length) {
				node.nextNode = new Node(new Point(points[pos++]));
				node = node.nextNode;
			}
		}
	}
	
	public Point[] getPoints() {
		int nodes = 0;
		Node n = point;
		
		//Check how many nodes there are
		while(n != null) {
			nodes++;
			n = n.nextNode;
		}
		
		//Create an array with the size of the amount of nodes
		Point[] points = new Point[nodes];
		
		//Go back to the beginning of the nodes
		n = point;
		
		//Add all the points from the nodes into the array
		for(int i = 0; i < nodes; i++) {
			points[i] = n.point;
			n = n.nextNode;
		}
		
		return points;
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
	
	}
	
	//Add a point to the end of the array
	public void addPoint(Point newPoint) {
	
	}
	
	//Add a point before a point specified by its name
	public void addPoint(Point newPoint, String pointName) {
	
	}
	
	//Remove a point defined by its frame from the array
	public void remove(String pointName) {
	
	}
	
	public Iterator<Point> iterator() {
		return Arrays.asList().iterator();
	}
}
