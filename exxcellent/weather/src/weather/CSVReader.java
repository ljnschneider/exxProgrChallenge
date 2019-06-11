package weather;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Vorgesehen zum Lesen einer CSV Datei, in deren erster Spalte der Name des Teams steht. Zusätzlich
 * sollten in zwei frei auswählbaren Spalten dieser Datei die erzielten bzw. die zugelassenen Tore stehen.
 * Stellt anhand dieser Werte die Teams fest, bei denen die Tordifferenz am geringsten war und gibt diese an.
 * 
 * @author Lennart Schneider
 * @see java.io.BufferedReader
 */
public class CSVReader implements Reader {
	
	/**
	 * Liest eine CSV Datei ein und erstellt zu jeder Zeile ein Team, das in einer Liste an Teams
	 * gespeichert wird. Diese Liste wird am Ende zurückgegeben.
	 * 
	 * @param path : Pfad der CSV
	 * @return : Liefert eine ArrayList mit allen Teams
	 */
	public List<Team> readthisfile(String path, int column1, int column2) {
		BufferedReader reader = null;
		ArrayList<Team> teams = new ArrayList<Team>();
		try {
			reader = new BufferedReader(new FileReader(path));
			// In der ersten Zeile stehen nur Überschriften.
			String line = reader.readLine();
			// Für jede Zeile wird ein Team eingefügt.
			while ((line = reader.readLine()) != null) {
				String[] words = line.split(",");
				String name;
				int goalsScored;
				int goalsAllowed;
				//Auslesen von name, goalsScored und goalsAllowed
				if (words.length < 3) {
					throw new IllegalArgumentException("Die Datei muss mindestens 3 vollständig ausgefüllte Spalten haben.");
				}
				else {
					//Falls Eingabefehler vorliegen: "try" bei der Berechnung der Differenz 
					try {
						name = words[0];
						goalsScored = Integer.parseInt(words[column1]);
						goalsAllowed = Integer.parseInt(words[column2]);
					}
					catch (NumberFormatException e){
						throw new IllegalArgumentException("In der ersten Spalte muss ein Name "
								+ "und den beiden angegebenen Spalten müssen Zahlen stehen");
					}
				}
				teams.add(new Team(name, goalsScored, goalsAllowed));
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
		return teams;
	}
	
	/**
	 * Wertet eine übergebene Liste mit Teams aus und gibt eine Liste mit den Teams zurück, bei denen
	 * die Tordifferenz minimal ist.
	 * 
	 * @param path : Pfad der CSV
	 * @return : Liefert eine ArrayList mit allen Teams mit minimaler Tordifferenz
	 */
	public List<Team> calcGoals (List<Team> teams){
		ArrayList<Team> minGoalSpreadTeams = new ArrayList<Team>();
		//max_value, damit der Wert gleich überschrieben wird.
		int minGoalSpread = Integer.MAX_VALUE;
		for (Team team : teams) {
			int tempSpread = Math.abs(team.getMaxTemp() - team.getMinTemp());
			if (tempSpread <= minGoalSpread) {
				if (tempSpread < minGoalSpread) {
					minGoalSpread = tempSpread;
					minGoalSpreadTeams = new ArrayList<Team>();
				}
				minGoalSpreadTeams.add(team);
			}
		}
		return minGoalSpreadTeams;
	}
}
