package weather;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Vorgesehen zum Lesen einer CSV Datei, in deren ersten drei Spalten und in dieser Reihenfolge
 * der Tag, die maximale Temperatur des Tages und die minimale Temperatur des Tages stehen.
 * Stellt anhand dieser Werte die Tage fest, an denen die Temperaturdifferenz am geringsten war,
 * und gibt diese an.
 * 
 * @author Lennart Schneider
 * @see java.io.BufferedReader
 */
public class CSVReader implements Reader {
	
	/**
	 * Liest eine CSV Datei ein und erstellt zu jeder Zeile einen Tag, der in einer Liste an Tagen
	 * gespeichert wird. Diese Liste wird am Ende zurückgegeben.
	 * 
	 * @param path : Pfad der CSV
	 * @return : Liefert eine ArrayList mit allen Tagen des Monats
	 */
	public List<Day> readthisfile(String path) {
		BufferedReader reader = null;
		ArrayList<Day> days = new ArrayList<Day>();
		try {
			reader = new BufferedReader(new FileReader(path));
			// In der ersten Zeile stehen nur Überschriften.
			String line = reader.readLine();
			// Für jede Zeile wird ein Tag eingefügt.
			while ((line = reader.readLine()) != null) {
				String[] words = line.split(",");
				int dayNumber;
				int maxTemp;
				int minTemp;
				//Auslesen der dayNumber, maxTemp und minTemp
				if (words.length < 3) {
					throw new IllegalArgumentException("Die Datei muss mindestens 3 vollständig ausgefüllte Spalten haben.");
				}
				else {
					//Falls Eingabefehler vorliegen: "try" bei der Berechnung der Differenz 
					try {
						dayNumber = Integer.parseInt(words[0]);
						maxTemp = Integer.parseInt(words[1]);
						minTemp = Integer.parseInt(words[2]);
					}
					catch (NumberFormatException e){
						throw new IllegalArgumentException("In der ersten, zweiten und dritten Spalte müssen Zahlen stehen");
					}
				}
				days.add(new Day(dayNumber, maxTemp, minTemp));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return days;
	}
	
	/**
	 * Wertet eine übergebene Liste mit Tagen aus und gibt eine Liste mit den Tagen zurück, an denen
	 * die Temperaturdifferenz minimal ist {@code : ArrayList<Day> minTempSpreadDays}.
	 * 
	 * @param path : Pfad der CSV
	 * @return : Liefert eine ArrayList mit allen Tagen des Monats mit minimaler Temperaturdifferenz
	 */
	public List<Day> calcDays (List<Day> days){
		ArrayList<Day> minTempSpreadDays = new ArrayList<Day>();
		int minTempSpread = Integer.MAX_VALUE;
		for (Day day : days) {
			int tempSpread = day.getMaxTemp() - day.getMinTemp();
			if (tempSpread <= minTempSpread) {
				if (tempSpread < minTempSpread) {
					minTempSpread = tempSpread;
					minTempSpreadDays = new ArrayList<Day>();
				}
				minTempSpreadDays.add(day);
			}
		}
		return minTempSpreadDays;
	}
}
