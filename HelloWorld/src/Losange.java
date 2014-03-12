/* quentin girard */
public class Losange extends Quadrilatere {

	//constructeur de la classe Losange
	public Losange(InterPoint a, InterPoint b, InterPoint c, InterPoint d, String couleurTrait, String couleuInterieur) {
		super(a, b, c, d, couleurTrait, couleuInterieur);
		this.type = "losange";
		// TODO Auto-generated constructor stub
	}

	//renvoie les propriétes du losange
	@Override
	public String proprietes() {
		return "Un losange est un parallélogramme ayant deux côtés consécutifs de même longueur. Il était anciennement appelé rhombe (et porte toujours un nom tiré de cette étymologie dans de nombreuses langues, comme rhombus en anglais). L'adjectif qui lui est relatif est rhombique.";
	}
}
