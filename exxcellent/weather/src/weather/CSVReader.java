package weather;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
	 * Berechnet Zeile für Zeile und somit für jeden Tag die Temperaturdifferenz, sucht die Tage, an denen sie
	 * minimal ist und speichert diese in einer Liste {@code : ArrayList<Integer> minTempSpreadDays}.  
	 * 
	 * @param path : Pfad der CSV
	 * @return : Liefert eine ArrayList mit den gesuchten Tagen zurück.
	 */
	public ArrayList<Integer> readFile(String path) {
		//Belegung von minTempSpread ist so groß, damit die Variable in Zeile 46 auf jeden Fall überschrieben wird.
		BufferedReader reader = null;
		int minTempSpread = Integer.MAX_VALUE;
		ArrayList<Integer> minTempSpreadDays = new ArrayList<Integer>();
		try {
			reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine();
			//Einlesen und bestimmen der Differenz
			while ((line = reader.readLine()) != null) {
				String[] words = line.split(",");
				if (words.length < 3) {
					throw new IllegalArgumentException("Die Datei muss mindestens 3 vollständig ausgefüllte Spalten haben.");
				}
				else {
					//Falls Eingabefehler vorliegen: "try" bei der Berechnung der Differenz 
					try {
						int lineTempSpread = Integer.parseInt(words[1]) - Integer.parseInt(words[2]);
						if (lineTempSpread <= minTempSpread) {
							if (lineTempSpread < minTempSpread) {
								minTempSpread = lineTempSpread;
								minTempSpreadDays = new ArrayList<Integer>();
							}
							minTempSpreadDays.add(Integer.parseInt(words[0]));
						} 
					}
					catch (NumberFormatException e){
						throw new IllegalArgumentException("In der ersten, zweiten und dritten Spalte müssen Zahlen stehen");
					}
				}
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
		return minTempSpreadDays;
	}
}
