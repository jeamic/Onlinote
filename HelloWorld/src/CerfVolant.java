/* quentin girard */
public class CerfVolant extends Quadrilatere {

	//constructeur de la classe CerfVolant
	public CerfVolant(InterPoint a, InterPoint b, InterPoint c, InterPoint d, String couleurTrait, String couleuInterieur) {
		super(a, b, c, d, couleurTrait, couleuInterieur);
		this.type = "cerf-volant";
		// TODO Auto-generated constructor stub
	}

	//renvoie les propriétes du cerf volant
	@Override
	public String proprietes() {
		// TODO Auto-generated method stub
		    return "Les paires de côtés égaux impliquent beaucoup de propriétés :"
		    + "\nLes diagonales sont perpendiculaires entre elles"
		    + "\nUne des diagonales divise le cerf-volant en deux triangles isocèles ; et l'autre le divise en deux triangles congrus"
		    + "\nLes cerfs-volants possèdent au moins un axe de symétrie ; cet axe est la diagonale qui divise en deux triangles congrus"
		    + "\nUn cerf-volant possède un cercle inscrit ; c’est-à-dire qu'il existe un cercle qui est tangent aux quatre côtés.";
	}
}
