/* quentin girard */
public class Point implements InterPoint{
	  private double x;
	  private double y;
	 
	  //constructeur dela classe Point
	  public Point(double x, double y) {
	    this.x = x;
	    this.y = y;
	  }
	  
	  //méthode pour créer un Point sans paramètre
	  public Point () {}
	  
	  //initialisation a posteriori
	  public void init (double x, double y) {
		    this.x = x;
		    this.y = y;
	  }
	 
	  //getters coordonnées
	  public double getX() { return x; }
	  public double getY() { return y; }
	   
	  //méthode affichage coordonnées
	  public void afficherCoordPoint () {
		  System.out.println("(" + getX() + "," + getY() + ")");
	  }
	  
	  //méthode obtention des coordonnées
	  public String getCoordPoint () {
		  String s = "(" + getX() + "," + getY() + ")";
		  return s;
	  }
}
