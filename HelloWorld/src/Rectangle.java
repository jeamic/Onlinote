/* quentin girard */
public class Rectangle extends Quadrilatere {

	//constructeur de la classe Rectangle
	public Rectangle(InterPoint a, InterPoint b, InterPoint c, InterPoint d, String couleurTrait, String couleuInterieur) {
		super(a, b, c, d, couleurTrait, couleuInterieur);
		this.type = "rectangle";
		// TODO Auto-generated constructor stub
	}
	//renvoie les propriétes du rectangle
	public String proprietes() {
		// TODO Auto-generated method stub
		return "En géométrie, un rectangle est un quadrilatère dont les quatre angles sont droits.";
	}
	
}
