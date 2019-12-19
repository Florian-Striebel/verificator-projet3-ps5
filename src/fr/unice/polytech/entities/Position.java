package fr.unice.polytech.entities;

/**
 * Classe qui represente les coordonnes actuelles des objets
 * @author patrick
 *
 */
public class Position {
    private int x;
    private int y;
    public static Position ORIGIN=new Position(0,0);

    /**
     * Constructeur de position
     * @param i
     * @param j
     */
    public Position(int i, int j) {
        this.x=i;
        this.y=j;
	}
	public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * Calcule la longueur du trajet entre le point A et B
     * @param other
     * @return int - distance entre les deux points
     */
    public int distanceTo(Position other){
        return Math.abs(x-other.x)+Math.abs(y-other.y);
    }

    @Override
    public String toString() {
        return "( "+x+" , "+y+" ) ";
    }

    public int distanceToOrigin(){
        return ORIGIN.distanceTo(this);
    }
}