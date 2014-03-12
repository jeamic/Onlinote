/* quentin girard */
import java.util.Vector;


public class HelloWorld {

	/**
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("Hello, World");
		
		//Afficher coordonnées d'un Point
		Point monPoint = new Point(2, 3);
		monPoint.afficherCoordPoint();
		
		//On crée quatre points qui sont des sommets
		InterPoint sommet1 = FabriquePoint.create("Point", -1, 1);
		InterPoint sommet2 = FabriquePoint.create("Point", 1, 1);
		InterPoint sommet3 = FabriquePoint.create("Point", -1, 1);
		InterPoint sommet4 = FabriquePoint.create("Point", -1, -1);
		
		// couleurs
		String colorInterieur = "bleu"; 
		String colorTrait = "vert";
		
		//Afficher quadrilatère
		Quadrilatere monQuadri = new Quadrilatere(sommet1, sommet2, sommet3, sommet4, colorTrait, colorInterieur);
		monQuadri.affiche();
		
		//Teste des classes filles de quadrilatère
		Carre monCarre = new Carre(sommet1, sommet2, sommet3, sommet4, colorTrait, colorInterieur);
		monCarre.affiche();
		
		CerfVolant monCerfVolant = new CerfVolant(sommet1, sommet2, sommet3, sommet4, colorTrait, colorInterieur);
		monCerfVolant.affiche();
		
		
		//Collection de quasdrilatères
		Vector<Quadrilatere> vectQuadrilatere = new Vector<Quadrilatere>();
		vectQuadrilatere.add(monQuadri);
		vectQuadrilatere.add(monCarre);
		vectQuadrilatere.add(monCerfVolant);
		
		for (int i = 0; i < vectQuadrilatere.size(); ++i)
		{
			vectQuadrilatere.elementAt(i).affiche();
		}
		
		//périmètre du carré
		System.out.println("Périmètre du carré: " + monCarre.getPerimetre());
		
		//afficher l'aire d'un carré
		System.out.println("Aire du carré: " + monCarre.getAire());
		
		//On crée quatre point polaires qui sont des sommets
		InterPoint sommet11 = FabriquePoint.create ("PointPolaire", Math.PI/2.0, 10);
		InterPoint sommet12 = FabriquePoint.create ("PointPolaire", 3*Math.PI/2.0, 10);
		InterPoint sommet13 = FabriquePoint.create ("PointPolaire", Math.PI/3.0, 10);
		InterPoint sommet14 = FabriquePoint.create ("PointPolaire", Math.PI/2.0, 10);
		
		//Afficher quadrilatère
		Quadrilatere monQuadri2 = new Quadrilatere(sommet11, sommet12, sommet13, sommet14, colorTrait, colorInterieur);
		monQuadri2.affiche();
		
		
	}

}
