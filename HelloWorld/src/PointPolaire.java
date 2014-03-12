/* quentin girard */
public class PointPolaire implements InterPoint{
	  private double angle;
	  private double rayon;
	 
	  //constructeur dela classe Point
	  public PointPolaire (double angle, double rayon) {
	    this.angle = angle;
	    this.rayon = rayon;
	  }
	  
	  //méthode pour créer un Point sans paramètre
	  public PointPolaire () {}
	  
	  //initialisation a posteriori
	  public void init (double angle, double rayon) {
		    this.angle = angle;
		    this.rayon = rayon;
	  }
	 
	  //getters coordonnées polaires
	  public double getAngle() { return angle; } //en radians
	  public double getRayon() { return rayon; }
	  
	  //getters coordonées cartésiennes
	  
//	  (double)Math.round(0.912385 * 100000) / 100000
	  
	  public double getX() { return rayon * Math.cos(angle); }
	  public double getY() { return rayon * Math.sin(angle); }
	   
	  //méthode affichage angle et rayon
	  public void afficherCoordPoint () {
		  System.out.println("(" + getX() + "," + getY() + ")");
	  }
	  
	  //méthode obtention des coordonnées polaires
	  public String getCoordPointPolaire () {
		  String s = "(" + getAngle() + "," + getRayon() + ")";
		  return s;
	  }
	  
	  //méthode obtention des coordonnées cartésiennes
	  public String getCoordPoint () {
		  String s = "(" + (int)getX() + "," + (int)getY() + ")";
		  return s;
	  }
}
