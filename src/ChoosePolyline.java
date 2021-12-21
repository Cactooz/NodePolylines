import java.util.Random;

public class ChoosePolyline {
	static final Random random = new Random();
		
	//Create a random point
	private static Point randomPoint() {
		//Give the point a random letter
		String name = "" + (char) (65 + random.nextInt(26));
		
		//Give the point random coordinates
		int x = random.nextInt(11);
		int y = random.nextInt(11);
		
		return new Point(name, x, y);
	}
	
	//Create a polyline with random points and color
	public static Polyline randomPolyline() {
		Polyline polyline = new VPolyline();
		
		//Get a random amount of points
		int totalPoints = 2 + random.nextInt(8);
		boolean[] chosenNames = new boolean[26];
		Point chosenPoint = null;
		char chosenChar = 0;
		
		for(int i = 0; i < totalPoints; i++) {
			//Create a new randomized point
			chosenPoint = randomPoint();
			//Get the name of the point
			chosenChar = chosenPoint.getName().charAt(0);
			
			//Only add the point if the name hasn't been used before
			if(!chosenNames[chosenChar - 65]) {
				polyline.addPoint(chosenPoint);
				chosenNames[chosenChar - 65] = true;
			}
		}
		
		//Get a random color for the polyline
		String color = "";
		int colorOption = random.nextInt(3);
		switch(colorOption) {
			case 0 -> color = "blue";
			case 1 -> color = "red";
			case 2 -> color = "yellow";
		}
		polyline.setColor(color);
		
		return polyline;
	}
}
