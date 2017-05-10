package thisPackage;

public class greatCircleDistance {
	
	public float getDistance(float x1, float x2, float y1, float y2){
		float distance;
		distance = 0;
		
		x1 = (float) Math.toRadians(x1);
		x2 = (float) Math.toRadians(x2);
		y1 = (float) Math.toRadians(y1);
		y2 = (float) Math.toRadians(y2);
		
		distance = (float) Math.acos(Math.sin(x1)*Math.sin(x2) + 
				Math.cos(x1)*Math.cos(x2) *
				Math.cos(y1-y2));
		
		
		return distance * 6400;
	}
	
	public static void main(String[] args){
		System.out.println(new greatCircleDistance().getDistance(21, 31, 51, 53));
	}
}
