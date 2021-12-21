public class Main {
	public static void main(String[] args) {
		Polyline polyline = null;
		polyline = new NPolyline ();
		//polyline = new VPolyline ();
		polyline.addPoint(new Point("A", 2, 4));
		polyline.addPoint(new Point("B", 6, 1));
		polyline.addPoint(new Point("C", 8, 12));
		polyline.addPoint(new Point("D", 4, 2));
		polyline.addPoint(new Point("E", 14, 8));
		
		System.out.println(polyline);
		
		polyline.remove("X");
		polyline.addPoint(new Point("Z", 5, 4), "E");
		
		polyline.setColor("red");
		
		System.out.println(polyline);
		
		for (Point horn : polyline)
			System.out.println (horn);
		
		Polyline[] random = new Polyline[10];
		for (int i = 0; i < 10; i++)
			random[i] = ChoosePolyline.randomPolyline();
		
		System.out.println(ChoosePolyline.shortestYellow(random));
	}
}
