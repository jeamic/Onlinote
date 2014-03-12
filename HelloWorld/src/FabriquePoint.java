/* quentin girard */
public class FabriquePoint {

	public static InterPoint create (String type_point, double x, double y) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		@SuppressWarnings("rawtypes")
		Class classe = Class.forName(type_point);
		InterPoint monPoint = (InterPoint) classe.newInstance();
		
		monPoint.init(x, y);
		
		return monPoint;
	}
	
}
