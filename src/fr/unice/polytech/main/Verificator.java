package fr.unice.polytech.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.unice.polytech.entities.Position;
import fr.unice.polytech.entities.Ride;
import fr.unice.polytech.io.Parser;

public class Verificator {

	public final int MAX_STEP, ROW, COL, FEE, BONUS, DISTANT, NB_RIDE, NB_CAR;
	public List<Ride> rides;
	public List<String> ridesInstruct;

	public Verificator(List<String> liste1, List<String> liste2) {
		List<Integer> l = Parser.getValueOption(liste1.get(0));
		ROW = l.get(0);
		COL = l.get(1);
		NB_CAR = l.get(2);
		NB_RIDE = l.get(3);
		BONUS = l.get(4);
		FEE = l.get(5);
		DISTANT = l.get(6);
		MAX_STEP = l.get(7);
		liste1 = liste1.subList(1, liste1.size());
		rides = Parser.initializeRide(liste1);
		ridesInstruct = liste2;
	}

	public void verification() {
		int score = Integer.parseInt(ridesInstruct.get(0));
		ridesInstruct.remove(0);
		List<String> values = new ArrayList<String>();
		for (String st : ridesInstruct) {
			values.add(st);
		}
		verifiyCourseOfVehicules(score, values);
	}

	private void verifiyCourseOfVehicules(int score, List<String> values) {
		Set<Ride> compt = new HashSet<Ride>();
		int calculatedScore = 0;
		int totnombreride = 0;
		int totnbvoiture = 0;
		for (String string : values) {
			int currentTime = 0;
			totnbvoiture++;
			Position voiture = new Position(0, 0);
			List<String> test = List.of(string.split(" "));
			int nombreride = Integer.parseInt(test.get(0));
			totnombreride += nombreride;
			test = test.subList(1, test.size());
			if (test.size() != nombreride) {
				System.out.println("erreur 4");
			}
			for (String id : test) {
				Ride r = rides.get(Integer.parseInt(id));
				if (!r.rideFeasible()) {
					System.out.println("impossible");
				}
				if (!compt.add(r)) {
					System.out.println("erreur 6");
				}
				if (r.getId() < 0 && r.getId() > NB_RIDE) {
					System.out.println("erreur 7");
				}
				if (currentTime+Math.abs(voiture.getX() - r.getStartPos().getX())
						+ Math.abs(voiture.getY() - r.getStartPos().getY()) <= r.getEarlyStartTime()) {
					calculatedScore += (Math.abs(r.getEndPos().getX() - r.getStartPos().getX())
							+ Math.abs(r.getEndPos().getY() - r.getStartPos().getY())) * this.DISTANT + this.FEE
							+ this.BONUS;
					currentTime = r.getEarlyStartTime()+Math.abs(r.getEndPos().getX() - r.getStartPos().getX())
					+ Math.abs(r.getEndPos().getY() - r.getStartPos().getY());
					voiture.setX(r.getEndPos().getX());
					voiture.setY(r.getEndPos().getY());
				}
				else {
					calculatedScore += (Math.abs(r.getEndPos().getX() - r.getStartPos().getX())
							+ Math.abs(r.getEndPos().getY() - r.getStartPos().getY())) * this.DISTANT + this.FEE;
					currentTime += Math.abs(voiture.getX() - r.getStartPos().getX())
							+ Math.abs(voiture.getY() - r.getStartPos().getY());
					voiture.setX(r.getStartPos().getX());
					voiture.setY(r.getStartPos().getY());
					currentTime += Math.abs(voiture.getX() - r.getEndPos().getX())
							+ Math.abs(voiture.getY() - r.getEndPos().getY());
					voiture.setX(r.getEndPos().getX());
					voiture.setY(r.getEndPos().getY());
				}
				if(voiture.distanceTo(r.getEndPos())!=0) {
					System.out.println("pb");
				}
				

				if (currentTime >= r.getLastStartTime()) {
					System.out.println("erreur 8");
				}
				if (currentTime > MAX_STEP) {
					System.out.println("RIP");
				}

			}
		}
		if (totnombreride > NB_RIDE) {
			System.out.println("erreur 5");
		}
		if (totnbvoiture != NB_CAR) {
			System.out.println("erreur 3 ");
		}
		if (calculatedScore != score) {
			System.out.println("" + calculatedScore + ":" + score);
			System.out.println("erreur 1");
		}
	}

	public int calculScore(Ride r, int currentTime, Position currentPosition) {
		if (arrivalTime(r, currentTime, currentPosition) <= r.getEarlyStartTime()) {
			return r.rideTime() * this.DISTANT + this.FEE + this.BONUS;
		} else {
			return r.rideTime() * this.DISTANT + this.FEE;
		}

	}

	public static int arrivalTime(Ride ride, int currentTime, Position currentPosition) {
		int pickUpTime = currentTime + currentPosition.distanceTo(ride.getStartPos());
		if (pickUpTime <= ride.getEarlyStartTime()) {
			return ride.getEarlyStartTime() + ride.rideTime();
		} else {
			return pickUpTime + ride.rideTime();
		}
	}

}
