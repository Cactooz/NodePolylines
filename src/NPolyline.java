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
}
