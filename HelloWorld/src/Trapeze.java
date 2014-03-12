/* quentin girard */
public class Trapeze extends Quadrilatere {

	//constructeur de la classe Trapeze
	public Trapeze(InterPoint a, InterPoint b, InterPoint c, InterPoint d, String couleurTrait, String couleuInterieur) {
		super(a, b, c, d, couleurTrait, couleuInterieur);
		this.type = "trapèze";
		// TODO Auto-generated constructor stub
	}
	
	//renvoie les propriétes du quadrilatère
	@Override
	public String proprietes() {
		return "Un trapèze est un quadrilatère, possédant deux côtés opposés parallèles.";
	}

}
