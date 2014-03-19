/* quentin girard  test commit*/
public class Carre extends Quadrilatere {

	//constructeur de la classe Carre
	public Carre(InterPoint a, InterPoint b, InterPoint c, InterPoint d, String couleurTrait, String couleuInterieur) {
		super(a, b, c, d, couleurTrait, couleuInterieur);
		this.type = "carré";
		//coucou
		//coucou2
		//coucou3
		// TODO Auto-generated constructor stub
	}
	
	//renvoie les propriétes du carré
	@Override
	public String proprietes() {
		return "Le carré est à la fois un losange et un rectangle, il possède donc les propriétés de ces deux quadrilatères. Il peut également être vu comme un polygone régulier, ce qui permet de démontrer ses propriétés par déduction de celles de ces polygones.";
	}
	
	public double getPerimetre () {
		double cote = this.getDistance(this.a, this.b);
		return 4 * cote;
	}
	
	public double getAire (){
		double cote = this.getDistance(this.a, this.b);
		return cote * cote;
	}

}
