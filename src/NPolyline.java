public class NPolyline implements Polyline{
	public static class Node {
		public Point point;
		public Node nextNode;
		
		public Node(Point point) {
			this.point = point;
			nextNode = null;
		}
	}
}
