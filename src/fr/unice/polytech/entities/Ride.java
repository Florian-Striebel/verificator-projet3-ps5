package fr.unice.polytech.entities;

/**
 * Classe qui modelise un trajet d'un point A a B, son heure de ramassage et de
 * depot
 * 
 * @author Patrick
 *
 */
public class Ride {
    private Position startPos;
    private Position endPos;
	private static int count=0;
    private int earlyStartTime;
    private int lastStartTime;
    private int id;

    /**
     * Constructeur de ride
     * @param startPos
     * @param endPos
     * @param earlyStartTime
     * @param lastStartTime
     */
    public Ride(Position startPos,Position endPos,int earlyStartTime,int lastStartTime) {
    	this.startPos=startPos;
    	this.endPos=endPos;
    	this.earlyStartTime=earlyStartTime;
    	this.lastStartTime=lastStartTime;
    	this.id= count++;
    }
    
    public Position getStartPos() {
        return startPos;
    }

   

    public Position getEndPos() {
        return endPos;
    }

   
    public int getEarlyStartTime() {
        return earlyStartTime;
    }

  
    public int getLastStartTime() {
        return lastStartTime;
    }

    public int rideTime(){
        return startPos.distanceTo(endPos);
    }


	public int getId() {
		return this.id;
    }


    

    public boolean rideFeasible() {
		if((rideTime()+getEarlyStartTime())<getLastStartTime()) 
				return true;
		return false;
	}
    
    @Override
    public String toString() {
		return this.startPos+"-"+this.endPos+"||"+this.earlyStartTime+"-"+this.lastStartTime;
    	
    }
}
