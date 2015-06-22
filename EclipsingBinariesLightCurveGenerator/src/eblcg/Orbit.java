/*
 * http://faculty.wwu.edu/~vawter/physicsnet/topics/Gravity/BinaryStars.html
 * http://faculty.wwu.edu/~vawter/physicsnet/topics/Gravity/KeplersLaws.html
 */
package eblcg;

public class Orbit {
	
	double totalMass = 0;
	double distance = 0;
	private final double G = Math.pow(6.671, -11);
	
	public Orbit(double eccentricity, double distance){
		//Assigning stars' orbital properties
		totalMass = LightCurveGenerator.star1.mass+LightCurveGenerator.star2.mass;
		this.distance = distance*Math.pow(1.49897870700, 11);
		LightCurveGenerator.star1.apoapsis = distance*LightCurveGenerator.star2.mass/(totalMass);
		LightCurveGenerator.star2.apoapsis = distance-LightCurveGenerator.star1.apoapsis;
		LightCurveGenerator.star1.eccentricity = eccentricity;
		LightCurveGenerator.star2.eccentricity = eccentricity;
		LightCurveGenerator.star1.semiMajorAxis = LightCurveGenerator.star1.apoapsis/(1+LightCurveGenerator.star1.eccentricity);
		LightCurveGenerator.star2.semiMajorAxis = LightCurveGenerator.star2.apoapsis/(1+LightCurveGenerator.star2.eccentricity);
		LightCurveGenerator.star1.periapsis = LightCurveGenerator.star1.semiMajorAxis*(1-LightCurveGenerator.star1.eccentricity);
		LightCurveGenerator.star2.periapsis = LightCurveGenerator.star2.semiMajorAxis*(1-LightCurveGenerator.star2.eccentricity);
		LightCurveGenerator.star1.period = 2*Math.PI*Math.sqrt((Math.pow(LightCurveGenerator.star1.semiMajorAxis+LightCurveGenerator.star2.semiMajorAxis, 3)/(G*totalMass)));
		LightCurveGenerator.star2.period = LightCurveGenerator.star1.period;
		LightCurveGenerator.star1.vPeri = Math.sqrt(G*totalMass*(2/LightCurveGenerator.star1.periapsis-1/LightCurveGenerator.star1.semiMajorAxis));
		LightCurveGenerator.star2.vPeri = Math.sqrt(G*totalMass*(2/LightCurveGenerator.star2.periapsis-1/LightCurveGenerator.star2.semiMajorAxis));
		LightCurveGenerator.star1.vApo = Math.sqrt(G*totalMass*(2/LightCurveGenerator.star1.apoapsis-1/LightCurveGenerator.star1.semiMajorAxis));
		LightCurveGenerator.star2.vApo = Math.sqrt(G*totalMass*(2/LightCurveGenerator.star2.apoapsis-1/LightCurveGenerator.star2.semiMajorAxis));
	}
	
	public double getEclipseTime(int starInFront){
		double eclipseTime = 0;
		//TODO
		return eclipseTime;
	}
}