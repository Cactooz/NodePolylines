import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

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
		//Set the start length to 0
		float length = 0;
		
		//Go back to the beginning of the nodes
		Node n = firstNode;
		
		//Add the length between the point to the next nodes point to the total length
		while(n != null) {
			length += n.point.distance(n.nextNode.point);
			n = n.nextNode;
		}
		
		return length;
	}
	
	//Add a point to the end of the array
	public void addPoint(Point newPoint) {
		if(firstNode == null) {
			firstNode = new Node(newPoint);
		} else {
			Node n = firstNode;
			
			while(n.nextNode != null) {
				n = n.nextNode;
			}
			
			//Add the new point as the next node for the last node
			n.nextNode = new Node(new Point(newPoint));
		}
	}
	
	//Add a point before a point specified by its name
	public void addPoint(Point newPoint, String pointName) {
		Node n = firstNode;
		
		while (n != null) {
			if(n.nextNode.point.getName().equals(pointName)) {
				//Save the next node
				Node tmpNextNode = n.nextNode;
				
				//Change the next node to the new node
				n.nextNode = new Node(new Point(newPoint));
				
				//Set the newPoints next node to the old nextNode
				n.nextNode.nextNode = tmpNextNode;
				
				return;
			}
			n = n.nextNode;
		}
	}
	
	//Remove a point defined by its frame from the array
	public void remove(String pointName) {
		if(firstNode == null) {
			System.out.print("The polyline is empty");
		} else {
			if(firstNode.point.getName().equals(pointName)) {
				firstNode = firstNode.nextNode;
			} else {
				Node n = firstNode;
				while (n.nextNode != null && n.nextNode.point.getName().equals(pointName)) {
					n = n.nextNode;
				}
				if(n.nextNode != null) {
					n.nextNode = n.nextNode.nextNode;
				}
			}
		}
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
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		if (firstNode != null) {
			sb.append("[");
			Node n = firstNode;
			while (n != null) {
				sb.append(n.point);
				n = n.nextNode;
			}
			sb.append("], ");
		}
		sb.append(this.color + ", " + this.width + "}");
		return sb.toString();
		
	}
	
	public Iterator<Point> iterator() {
		return Arrays.asList(this.getPoints()).iterator();
	}
}
