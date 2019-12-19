package fr.unice.polytech.io;

import java.util.ArrayList;
import java.util.List;

import fr.unice.polytech.entities.Position;
import fr.unice.polytech.entities.Ride;

/**
 * Classe qui s'occupe de recuperer les split les donnees recus
 * @author florian
 *
 */
public class Parser {

	/**
	 * Renvoie une liste contenant les parametres passe dans la string
	 * @param listoption
	 * @return liste
	 */
	public static List<Integer> getValueOption(String listoption) {
		List<Integer> listOpt=new ArrayList<Integer>();
		String[] listToParse=listoption.split(" ");
		for(int i=0;i<listToParse.length;i++) {
			listOpt.add(Integer.parseInt(listToParse[i]));
		}
		return listOpt;
	}
	
	/**
	 * 
	 * Renvoie un set contenant tout les rides possibles de la liste passe en parametre
	 * @param listStringRide
	 * @return Set avec chaque ride
	 */
	public static List<Ride> initializeRide(List<String> listStringRide) {
		List<Ride> listRide=new ArrayList<Ride>();
		for(String rideString: listStringRide) {
			String[] listToParse=rideString.split(" ");
			int[] intList= new int[listToParse.length];
			for(int i=0;i<listToParse.length;i++) {
				intList[i]=Integer.parseInt(listToParse[i]);
			}
			listRide.add(new Ride(new Position(intList[0],intList[1]),new Position(intList[2], intList[3]), intList[4], intList[5]));
		}
		return listRide;
	}
}
