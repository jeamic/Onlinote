/* quentin girard */
public class Parallelogramme extends Quadrilatere {

	//constructeur de la classe Parallélogramme
	public Parallelogramme(InterPoint a, InterPoint b, InterPoint c, InterPoint d, String couleurTrait, String couleuInterieur) {
		super(a, b, c, d, couleurTrait, couleuInterieur);
		this.type = "parallelogramme";
		// TODO Auto-generated constructor stub
	}

	//renvoie les propriétes du parallélogramme
	@Override
	public String proprietes() {
		return "Un parallélogramme, en géométrie, est un quadrilatère dont les côtés opposés sont parallèles deux à deux.";
	}

}
