/* quentin girard */
public class Parallelogramme extends Quadrilatere {

	//constructeur de la classe Parall�logramme
	public Parallelogramme(InterPoint a, InterPoint b, InterPoint c, InterPoint d, String couleurTrait, String couleuInterieur) {
		super(a, b, c, d, couleurTrait, couleuInterieur);
		this.type = "parallelogramme";
		// TODO Auto-generated constructor stub
	}

	//renvoie les propri�tes du parall�logramme
	@Override
	public String proprietes() {
		return "Un parall�logramme, en g�om�trie, est un quadrilat�re dont les c�t�s oppos�s sont parall�les deux � deux.";
	}

}
//coucouéééé 