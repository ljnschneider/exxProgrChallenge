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
	List<Day> result = calculator.readthisfile(***Pfad der weather.csv***);
	result = calculator.calcDays(result);
	//Das Folgende muss angepasst werden falls mehr als ein Tag herauskommt. 
	
	String anfang = "Am ";
	String dazwischen = "";
	String ende = ". des Monats ist die Temperaturdifferenz am kleinsten.";
	
	//Falls mehr als ein Tag die minimale Temperaturdifferenz erreicht.
	switch(result.size()) {
	case 0:	System.out.println("Bitte eine CSV Datei mit ausreichend Einträgen benutzen.");
			break;
	case 1: dazwischen = dazwischen + result.get(0).getDayNumber();
			break;
	case 2: dazwischen = result.get(0).getDayNumber() + ". und " + result.get(1).getDayNumber();
			break;
	default: for (int i = result.size(); i>1; i--) {
				dazwischen = dazwischen + result.get(i).getDayNumber() + "., ";
			}
			dazwischen = dazwischen + result.get(1).getDayNumber() + ". und " + result.get(0).getDayNumber();
			
	}
	System.out.println(anfang + dazwischen + ende);
}
}

