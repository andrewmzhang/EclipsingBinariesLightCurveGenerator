/*
 * http://faculty.wwu.edu/~vawter/physicsnet/topics/Gravity/BinaryStars.html
 * http://faculty.wwu.edu/~vawter/physicsnet/topics/Gravity/KeplersLaws.html
 */
package eblcg;

public class Orbit {
	
	double totalMass = 0;
	
	public Orbit(double eccentricity, double distance){
		//Assigning stars' orbital properties
		totalMass = LightCurveGenerator.star1.mass+LightCurveGenerator.star2.mass;
		LightCurveGenerator.star1.apoapsis = distance*LightCurveGenerator.star2.mass/(totalMass);
		LightCurveGenerator.star2.apoapsis = distance-LightCurveGenerator.star1.apoapsis;
		LightCurveGenerator.star1.eccentricity = eccentricity;
		LightCurveGenerator.star2.eccentricity = eccentricity;
		LightCurveGenerator.star1.semiMajorAxis = LightCurveGenerator.star1.apoapsis/(1+LightCurveGenerator.star1.eccentricity);
		LightCurveGenerator.star2.semiMajorAxis = LightCurveGenerator.star2.apoapsis/(1+LightCurveGenerator.star2.eccentricity);
		LightCurveGenerator.star1.periapsis = LightCurveGenerator.star1.semiMajorAxis*(1-LightCurveGenerator.star1.eccentricity);
		LightCurveGenerator.star2.periapsis = LightCurveGenerator.star2.semiMajorAxis*(1-LightCurveGenerator.star2.eccentricity);
	}
}
