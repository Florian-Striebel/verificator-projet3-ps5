package fr.unice.polytech.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.unice.polytech.entities.Position;
import fr.unice.polytech.entities.Ride;
import fr.unice.polytech.io.Parser;

public class Verificator {
	
	public final int MAX_STEP,ROW,COL,FEE,BONUS,DISTANT,NB_RIDE;
	public List<Ride> rides;
	public List<String> ridesInstruct;
	int nbOfVehicules;
	int nbOfRide;
	public Verificator(List<String> liste1 ,List<String> liste2) {
		List<Integer> l=Parser.getValueOption(liste1.get(0));
		ROW=l.get(0);
		COL=l.get(1);
		NB_RIDE=l.get(3);
		BONUS=l.get(4);
		FEE=l.get(5);
		DISTANT=l.get(6);
		MAX_STEP=l.get(7);
		liste1=liste1.subList(1, liste1.size());
		rides=Parser.initializeRide(liste1);
		ridesInstruct=liste2;
		nbOfRide=0;
		nbOfVehicules=0;
		}
	
	
	public void verification() {
		Set <Ride> rideMade=new HashSet();
		int score=Integer.parseInt(ridesInstruct.get(0));
		List<Integer>  values= new ArrayList<Integer>();
		for(String st:ridesInstruct) {
			String[] list=st.split(" ");
			for(String val:list) {
				values.add(Integer.parseInt(val));
			}		
		}
		verifiyCourseOfVehicules(score,values);
	}


	private void verifiyCourseOfVehicules(int score,List<Integer> values) {
		// TODO Auto-generated method stub

		
		int i=1;
		int calculatedScore=0;
		int currentTime=0;
		boolean error8=false;
		int PosLastCourse=1;
		while(i<values.size()&& !error8) {
			PosLastCourse+= values.get(i)+1;
			Position vehiclePos= new Position(0,0);
			i++;
			currentTime=0;
			System.err.println("current 0");
			vehiclePos=new Position(0,0);
			for(int j=i;j<PosLastCourse;j++) {
				nbOfRide++;
				System.out.println(values.get(j)+"--"+currentTime+"--"+arrivalTime(rides.get(values.get(j)), currentTime, vehiclePos));
				if(arrivalTime(rides.get(values.get(j)), currentTime, vehiclePos)<MAX_STEP){
					calculatedScore+=calculScore(rides.get(values.get(j)),currentTime,vehiclePos);
					//System.out.println("b"+(currentTime)+"---"+rides.get(values.get(j)).getStartPos()+"--"+rides.get(values.get(j)).getEndPos());
					currentTime+=arrivalTime(rides.get(values.get(j)), currentTime, vehiclePos);
					vehiclePos=rides.get(values.get(j)).getEndPos();
					//System.out.println("b"+currentTime);
				}else {
					//System.out.println(vehiclePos+"["+currentTime+"]"+"("+rides.get(values.get(j)).getId()+")"+rides.get(values.get(j)));
					//System.out.println("error8");
				}
				i++;
			}
			//i++;
			/*if(error8) {
				System.out.println("error8");
			}*/
			nbOfVehicules++;
		}
	}
	
    public int calculScore(Ride r,int currentTime,Position currentPosition){
        if(arrivalTime(r,currentTime,currentPosition)<=r.getEarlyStartTime()){
            return r.rideTime()*this.DISTANT+this.FEE+this.BONUS;
        }else{
            return r.rideTime()*this.DISTANT+this.FEE;
        }
        
    }
    
    public static int arrivalTime(Ride ride,int currentTime,Position currentPosition){
        int pickUpTime = currentTime + currentPosition.distanceTo(ride.getStartPos());
        //System.out.println("pkTime"+currentTime+"-"+ (currentTime + currentPosition.distanceTo(ride.getStartPos()))+"--"+currentPosition.distanceTo(ride.getStartPos()));
        if(pickUpTime < ride.getEarlyStartTime()){
        	return ride.getEarlyStartTime()+ride.rideTime();
        }
        else{
            return pickUpTime+ride.rideTime();
        }
    }

    
}
