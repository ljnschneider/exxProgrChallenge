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
	Reader rechner = new CSVReader();
	List<Integer> ergebnis = rechner.readFile(***Pfad der weather.csv***);
	//Das Folgende muss angepasst werden falls mehr als ein Tag herauskommt. 
	String ausgabe = "Am ";
	for (Integer wert : ergebnis) {
		ausgabe = ausgabe + wert + ". ist die Temperaturdifferenz am kleinsten.";
	}
	System.out.println(ausgabe);
}
}

