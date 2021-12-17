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
}
