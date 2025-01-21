package utils;
/*
 * Class Position
 * Cette classe permet de représenter un point.
 * Il est utilisé pour la représentation gaphique de l'arbre.
 */
public class Position {
	private int x;
	private int y;
	private float angle;
	
	/*
	 * COnstructeur de la classe Point
	 * @param x de type int, c'est l'abscisse du point
	 * @param y représente l'ordonné du point
	 * @param angle : l'angle d'orientation du point en degré
	 * @return un point initialisé avec les valeurs passées en paramètre
	 */
	public Position(int x, int y, float angle) {
		this.x = x;
		this.y = y;
		this.angle = angle;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}
	
	@Override
	public String toString() {
		return "("+x+","+y+") - "+angle;
	}
}