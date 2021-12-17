import java.util.Arrays;
import java.util.Iterator;

public class NPolyline implements Polyline{
	public static class Node {
		//The point in the node
		public Point point;
		//The reference to the next node
		public Node nextNode;
		
		//Constructor for the node
		public Node(Point point) {
			this.point = point;
			nextNode = null;
		}
	}
	
	private Node firstNode;
	private String color = "black";
	private int width = 1;
	
	public NPolyline() {
		firstNode = null;
	}
	
	public NPolyline(Point[] points) {
		if(points.length > 0) {
			//Create a new node with the point from the first point in the array
			Node node = new Node(new Point(points[0]));
			
			//Set the point to reference the node
			firstNode = node;
			int pos = 1;
			while(pos < points.length) {
				//Set that the next node is another node with the next point from the array
				node.nextNode = new Node(new Point(points[pos++]));
				
				//Go to the next node
				node = node.nextNode;
			}
		}
	}
	
	public Point[] getPoints() {
		//Get the amount of nodes
		int amount = nodeAmount(firstNode);
		
		//Create an array with the size of the amount of nodes
		Point[] points = new Point[amount];
		
		//Go back to the beginning of the nodes
		Node n = firstNode;
		
		//Add all the points from the nodes into the array
		for(int i = 0; i < amount; i++) {
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
	
	//Get the amount of nodes
	private int nodeAmount(Node nodeIn) {
		int amount = 0;
		Node n =  nodeIn;
		
		//Check how many nodes there are
		while(n != null) {
			amount++;
			n = n.nextNode;
		}
		
		return amount;
	}
	
	public Iterator<Point> iterator() {
		return Arrays.asList().iterator();
	}
}
