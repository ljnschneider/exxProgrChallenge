package weather;

import java.util.List;

/**
 * Vorgesehen zum Lesen einer Datei mit Daten über Fußball Teams. Stellt die Teams fest, bei denen die 
 * Tordifferenz am gerinsten war und gibt diese an.
 * 
 * @author Lennart Schneider
 *
 */
public interface Reader {
	
	/**
	 * Liest eine Datei ein und gibt eine Liste an Teams zurück.
	 * 
	 * @param path : Der Pfad der Datei
	 * @return Liefert eine Liste mit allen Teams aus der Datei zurück.
	 */	
	public List<Team> readthisfile(String path, int column1, int column2);
	
	/**
	 * Berechnet zu gegebenen Teams die Teams, bei denen die Tordifferenz minimal ist. 
	 * 
	 * @param days : Erwartet eine Liste mit Teams
	 * @return Liefert eine Liste mit allen Teams mit minimaler Tordifferenz
	 */
	public List<Team> calcGoals(List<Team> days);
}
