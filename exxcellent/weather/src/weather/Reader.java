package weather;

import java.util.List;

/**
 * Vorgesehen zum Lesen einer Datei mit Wetterdaten. Stellt die Tage fest, an denen die Temperaturdifferenz 
 * am gerinsten war und gibt diese an.
 * 
 * @author Lennart Schneider
 *
 */
public interface Reader {
	
	/**
	 * Liest eine Datei ein und gibt eine Liste an Tagen eines Monats zurück.
	 * 
	 * @param path : Der Pfad der Datei
	 * @return Liefert eine Liste mit den Tagen aus der Datei zurück zurück.
	 */	
	public List<Day> readthisfile(String path);
	
	/**
	 * Berechnet zu einer gegebenen Liste an Tagen die Tage, an denen die Temperturdifferenz minimal ist. 
	 * 
	 * @param days : Erwartet eine Liste mit Tagen
	 * @return Liefert eine Liste mit allen Tagen des Monats mit minimaler Temperaturdifferenz
	 */
	public List<Day> calcDays(List<Day> days);
}
