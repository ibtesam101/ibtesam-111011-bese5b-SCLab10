package thisPackage;

public class greatCircleDistance {
	
	public float getDistance(Double double1, Double double2, Double double3, Double double4){
		float distance;
		distance = 0;
		
		double1 = Math.toRadians(double1);
		double2 = Math.toRadians(double2);
		double3 =  Math.toRadians(double3);
		double4 =  Math.toRadians(double4);
		
		distance = (float) Math.acos(Math.sin(double1)*Math.sin(double2) + 
				Math.cos(double1)*Math.cos(double2) *
				Math.cos(double3-double4));
		
		
		return distance * 6400;
	}
	
	public static void main(String[] args){
		System.out.println(new greatCircleDistance().getDistance(21.0, 31.0, 51.0, 53.0));
	}
}
