package fr.unice.polytech.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class VerificatorMain {

	
	public static void main(String[] args) {
		List<String> list1=new ArrayList<String>();
		List<String> list2=new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		boolean file2=false;
		while(sc.hasNextLine()) {
			String line =sc.nextLine();
			if(line.contains("[INFO]")) {
				file2=true;
			}else if(!file2){
				list1.add(line);
			}else {
				list2.add(line);
			}
		}
		Verificator verif=new Verificator(list1, list2);
		verif.verification();
		
		sc.close();
	}
}
