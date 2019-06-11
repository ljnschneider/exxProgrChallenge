package weather;

import java.util.List;

/**
 * Klasse zum Starten 
 * @author Lennart Schneider
 *
 */
public class start {
public static void main(String[] args)
{
	Reader calculator = new CSVReader();
	List<Team> result = calculator.readthisfile(***Pfad der football.csv***,5,6);
	result = calculator.calcGoals(result);
	//Das Folgende muss angepasst werden falls mehr als ein Tag herauskommt.
	
	String anfang = "Bei ";
	String dazwischen = "";
	String ende = " ist die Tordifferenz am kleinsten.";
	
	//Falls mehr als ein Tag die minimale Temperaturdifferenz erreicht.
	switch(result.size()) {
	case 0:	System.out.println("Bitte eine CSV Datei mit ausreichend Einträgen benutzen.");
			break;
	case 1: dazwischen = dazwischen + result.get(0).getName();
			break;
	case 2: dazwischen = result.get(1).getName() + " und " + result.get(0).getName();
			break;
	default: for (int i = result.size()-1; i>1; i--) {
				dazwischen = dazwischen + result.get(i).getName() + ", ";
			}
			dazwischen = dazwischen + result.get(1).getName() + " und " + result.get(0).getName();
			
	}
	System.out.println(anfang + dazwischen + ende);
}
}

