/* quentin girard */
public interface InterPoint {

	  //getters coordonées cartésiennes 
	  public double getX();
	  public double getY();

	  //méthode affichage angle et rayon
	  public void afficherCoordPoint ();
	  
	  //méthode obtention des coordonnées cartésiennes
	  public String getCoordPoint ();
	  
	  //initialisation
	  public void init (double x, double y);
}
