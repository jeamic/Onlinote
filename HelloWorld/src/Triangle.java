/* quentin girard */
public class Triangle {
	  //données de la classe
	  protected InterPoint a;
	  protected InterPoint b;
	  protected InterPoint c;
	  protected String type;
	  protected String couleurInterieur;
	  protected String couleurTrait;
	 
	  //constructeur de la classe Quadrilatère
	  public Triangle (InterPoint a, InterPoint b, InterPoint c, String couleurTrait, String couleurInterieur) {
	    this.a = a;
		this.b = b;
	    this.c = c;
	    this.couleurTrait = couleurTrait;
	    this.couleurInterieur = couleurInterieur;
	  }
	 
	  //getters
	  public InterPoint getA() { return a; }
	  public InterPoint getB() { return b; }
	  public InterPoint getC() { return c; }
	  public String getType() { return type; }
	  
	  //méthode d'affichage
	  public void affiche () {
		  System.out.println(this);
	  }
	  
	  //réécriture de la classe toString
	  public String toString (){
		  String phrase_type_quadri = type();
		  String phrase_couleur = couleur();
		  String phrase_proprietes = proprietes();
		  String phrase_coord = coordonnees();
		  String phrase = phrase_type_quadri + phrase_couleur +  phrase_proprietes + '\n' + phrase_coord + "\n\n";
		return phrase;
	  }
	  
	  //renvoie le type du quadrilatère
	  public String type(){
		  String phrase_type_quadri = "Je suis un " + getType() + ". ";
		return phrase_type_quadri;
	  }
	  
	  //renvoie les coordonnées des quatre points du quadrilatère
	  public String coordonnees () {
		  String phrase_coord = "Mes sommets ont pour coordonnées: " +
				  	a.getCoordPoint() +
				  	b.getCoordPoint() +
				  	c.getCoordPoint();
		return phrase_coord;
	  }
	  
	  //renvoie les propriétes du quadrilatère
	  public String proprietes () {
		  return "Pas de propriété spéciale";
	  }
	  
	  //obtenir la distance entre deux points
	  public double getDistance  (InterPoint pt1, InterPoint pt2) {
		  double distance = Math.sqrt( Math.pow(b.getX() - a.getX(), 2) 
				  					 + Math.pow(b.getY() - a.getY(), 2));
		  return distance;
	  }
	  
	  //calcul de l'aire
	  public double getAire () {
		  return 0;
	  }
	  
	  //renvoie les couleurs du polygône
	  public String couleur () {
		  String s;
		  s = " La couleur de mon trait est " + couleurTrait + " et la couleur de mon intérieur est " + couleurInterieur + "\n" ;
		  return s;
	  }
}
